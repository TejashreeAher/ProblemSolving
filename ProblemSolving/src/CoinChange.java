
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tejashree.aher
 */
public class CoinChange {
    private static Map<Integer, List<List<Integer>>> combinations = new HashMap<Integer, List<List<Integer>>>();
    
    
    private static boolean compareCollections(List<Integer> a, List<Integer> b){
        if(a.size() != b.size())
            return false;
        Map<Integer, Integer> aMap = new HashMap<>();
        Map<Integer, Integer> bMap = new HashMap<>();
        for(int i=0; i<a.size(); i++){
            int aOccur = aMap.containsKey(a.get(i))?aMap.get(a.get(i))+1:1;
            aMap.put(a.get(i), aOccur);
            int bOccur = bMap.containsKey(b.get(i))?bMap.get(b.get(i))+1:1;
            bMap.put(b.get(i), bOccur);
        }
         return aMap.equals(bMap);
//        if(!aMap.keySet().equals(bMap.keySet()))
//            return false;
//        for(int i : aMap.keySet()){
//            if(!aMap.get(i).equals(bMap.get(i))){
//                return false;
//            }
//        }
//        return true;
    }
    
    private static boolean doesListContain(List<List<Integer>> listOfList, List<Integer> list){
        for(List<Integer> l : listOfList){
            if(compareCollections(l, list)){
                return true;
            }
        }
        return false;
    }
    
    private static List<List<Integer>> getComList(int n, int[] coins){
        if(n<0){
            return null;
        }
        List<List<Integer>> AList = new ArrayList<List<Integer>>();
        if(n == 0){
            return AList;
        }
        if(combinations.containsKey(n)){
            return combinations.get(n);
        }
        for(int i=0; i<coins.length; i++){
            List<List<Integer>> list = getComList(n-coins[i], coins);
            if(list != null){
                if(list.isEmpty() && n-coins[i] == 0){
                    List l = new ArrayList<Integer>();
                    l.add(coins[i]);
                    if(!doesListContain(AList, l)){
                      AList.add(l);
                    }
                }else{
                  for(List<Integer> l : list){
                      List<Integer> lNew = new ArrayList<Integer>();
                      lNew.addAll(l);
                    lNew.add(coins[i]);
                    if(!doesListContain(AList, lNew)){
                      AList.add(lNew);
                    }
                   } 
                }
                
            }
        }
        combinations.put(n, AList);
        return AList;
    }
    
    
    public static void main(String[] args){
//        int[] coins = {2,5,3,6};
//        System.out.println(getComList(10, coins));
//        System.out.println(getComList(10, coins).size());
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String firstLine = br.readLine();
            String[] arr = firstLine.split("\\s");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            
            String c = br.readLine();
            String[] coinsArr = c.split("\\s");
            int[] coins = new int[m];
            for(int i=0; i<m; i++){
                coins[i] = Integer.parseInt(coinsArr[i].trim());
            }
            System.out.println(getComList(n, coins).size());
        } catch (IOException ex) {
            Logger.getLogger(CoinChange.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
