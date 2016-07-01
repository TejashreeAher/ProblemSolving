/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package problemsolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tejashree.aher
 * The first round of Armageddon begins. Numz locks Puchi in a cage and gives him a string S, consisting of only numerical digits [0-9] , and declares:

    I shall release a hungry lion in this cage. You shall not fight with the lion, but only satisfy its hunger. The lion eats every minute a 
    * number that does not leave a remainder when divided by 6. You can use a subsequence of the string S to form a number and feed 
    * it to the lion. Beware! You can use each subsequence only once. Good Luck Mortal!

Given the string S, can you tell how many minutes will Puchi survive? 
 */
public class NumericalArmageddon {
    private static HashMap<String, List<String>> StrToSubSeqList = new HashMap<String, List<String>>();
    private static int count = 0;
    
    private static List<String> getAllSubSequences(String s, int start, int end){
        List<String> resultHere = new ArrayList<String>();
        if(s == null || s.length() == 0 || start > end){
            resultHere.add("");
            return resultHere;
        }
        String subString = s.substring(start, end+1);
        if(subString.trim().length() > 0 && StrToSubSeqList.containsKey(subString)){
            return StrToSubSeqList.get(subString);
        }
        ///char at 'start' is present in the subsequence
        for(String str : getAllSubSequences(s, start+1, end)){
            resultHere.add(Character.toString(s.charAt(start)).concat(str));
        }
        //char at 'start' is not present in the sebsequence
        resultHere.addAll(getAllSubSequences(s, start+1, end));
        StrToSubSeqList.put(s.substring(start, end+1), resultHere);
        return resultHere;
    }
    
    private static void getMaxSurvivalMinutes(String s) throws Exception{
        List<String> allSubSeq = getAllSubSequences(s, 0, s.length()-1);
        int maxMinsSurvived = 0;
        for(String str: allSubSeq){
            if(str.trim().length() > 0){//needed because an emoty string will be present in the list
                if(Integer.parseInt(str.trim()) % 6 == 0){
                    maxMinsSurvived ++;
                }
            }
        }
        System.out.println(maxMinsSurvived);
    }
    
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            int N;
            try{
                N = Integer.parseInt(line);
            }catch(Exception e){
                N = 0;
            }
            
            if(N==0){
                return;
            }
            List<Integer> output = new ArrayList<Integer>(N);
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                if(s.length() > 1000000){
                    return;
                }
                getMaxSurvivalMinutes(s);
            }
        } catch (IOException ex) {
            Logger.getLogger(NumericalArmageddon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(NumericalArmageddon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
