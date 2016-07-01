
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
 *Given a string S, answer Q queries.
Each query contains a string qstr. Please output the number of substrings of S that contain some anagram of qstr as a subsequence.
Input Format:
The first line of input file contains an integer T that denotes the number of test cases to follow.
Each of the test cases contain the string S in first line. The next line contains an integer Q. Each of the next Q lines contain a query string qstr
Output Format:
The output file should contain answers for each query in a new line.
Constraints:
1 ≤ T ≤ 3
1 ≤ |S| ≤ 105
1 ≤ Q ≤ 200
None of the characters in qstr shall be repeated.
All the strings will only contain characters from A-Z, a-z and 0-9.
 * @author tejashree.aher
 */
public class SubstringQueries {
    
    private static Map<Character, List<Integer>> getOccurencesMap(String bigStr, String smallStr){
        Map<Character, List<Integer>> occurence = new HashMap<>();
        char[] cArr = bigStr.toCharArray();
        for(int i=0; i<cArr.length; i++){
            if(smallStr.indexOf(cArr[i]) != -1){
                List<Integer> occur;
                if(occurence.containsKey(cArr[i])){
                    occur = occurence.get(cArr[i]);
                    
                }else{
                    occur = new ArrayList<>();
                }
                occur.add(i);
                occurence.put(cArr[i], occur);
            }
        }
        return occurence; ///the occurence of each character is sorted automatically as we added as they occur
    }
    
    private static List<Integer> getSortedOccurencesOfAll(String smallStr, Map<Character, List<Integer>> occurMap){
        List<Integer> currentIndices = new ArrayList<>();
        for(char c : smallStr.toCharArray()){
            List<Integer> occurMapOfChar = occurMap.get(c);
            if(occurMapOfChar == null || occurMapOfChar.isEmpty()){
                return null;///this character is not preent in bigStr
            }
            int index = occurMap.get(c).get(0);
            currentIndices.add(index);
        }
        Collections.sort(currentIndices);
        return currentIndices;
    }
    
    private static void getSubStrCount(String bigStr, String smallStr){
        Map<Character, List<Integer>> occurencesMap = getOccurencesMap(bigStr, smallStr);
        List<Integer> currentIndices = getSortedOccurencesOfAll(smallStr, occurencesMap);
        if(currentIndices == null){
            System.out.println(0); ///no occurence as some chars are missing in bigStr
            return;
        }
        int length = bigStr.length();
        char lowestChar = 0;
        int startStrINdex = 0;
        int count = 0;
        int i = 0;
        while( i < currentIndices.size()){
            int index = currentIndices.get(i);
            char currentLowestChar = bigStr.charAt(index);
            int endSbStr = length-currentIndices.get(currentIndices.size()-1);
//            if(currentLowestChar == lowestChar){
//                count = count + (endSbStr);
//            }else{
                count = count + ((index-startStrINdex +1)* endSbStr);
//            }
            startStrINdex = index + 1;
            ArrayList<Integer> listOfOccur = (ArrayList<Integer>) occurencesMap.get(currentLowestChar);
            listOfOccur.remove(Integer.valueOf(index));
            if(occurencesMap.get(currentLowestChar) == null || occurencesMap.get(currentLowestChar).isEmpty()){
                System.out.println(count);
                return;
            }
            lowestChar = currentLowestChar;
            currentIndices.add(occurencesMap.get(currentLowestChar).get(0));
//            Collections.sort(currentIndices);
            i++;
        }
        System.out.println(count);
    }
    
  static String[] cavityMap(String[] arr) {
        for(int i=0; i<arr.length; i++){
            if(i != 0 && i!= arr.length-1){
                char[] rowArr = arr[i].toCharArray();
                char[] rowNextArray = arr[i-1].toCharArray();
                char[] rowPrevArray = arr[i+1].toCharArray();
                for(int j=0; j<rowArr.length; j++){
                    if(j!=0 && j!=rowArr.length-1){
                        if(Character.getNumericValue(rowPrevArray[j]) < Character.getNumericValue(rowArr[j]) && Character.getNumericValue(rowNextArray[j]) < Character.getNumericValue(rowArr[j])){
                            if(Character.getNumericValue(rowArr[j-1]) < Character.getNumericValue(rowArr[j]) && Character.getNumericValue(rowArr[j+1]) < Character.getNumericValue(rowArr[j])){
                                rowArr[j] = 'X';
                            }
                        }
                    }
                }
                arr[i] = String.valueOf(rowArr);
            }
        }
        return arr;
    }
  
  private static String getProtocol(String addr){
      if(addr == null || addr.length() == 0){
          return "Neither";
      }
      if(addr.contains(".")){
        String[] arrStr = addr.split("\\.");
        boolean isIpv4 = true;
        if(arrStr.length == 4){
            for(int i=0; i<arrStr.length; i++){
                if(Integer.parseInt(arrStr[i]) < 0 || Integer.parseInt(arrStr[i]) > 255){
                    isIpv4 = false;
                    break;
                }
            }
            if(isIpv4){
                return "IPv4";
            }
        }
      }else if(addr.contains(":")){
              String[] arrStr2 = addr.split(":");
              boolean isIpv6 = true;
              if(arrStr2.length == 8){
                  for(int i=0; i<arrStr2.length; i++){
                      if(arrStr2[i].length() < 5){
                           boolean isHex = arrStr2[i].matches("[0-9A-Fa-f]+");
                            if(!isHex){
                                isIpv6 = false;
                                break;
                            }
                      }else{
                          isIpv6 = false;
                          break;
                      }
                  }
                  if(isIpv6){
                      return "IPv6";
                  }
              }
      }
      return "Neither";
  }
  
    private long getSum(String[] nums){
        long sum = 0;
        for(String num : nums) {
            sum = sum + Long.valueOf(num);
        }
        return sum;
    }
  
    public static void main(String[] args) {
        System.out.println(getProtocol("22.231.113.64"));
//        String[] arr = new String[4];
//        arr[0] = "1112";
//        arr[1] = "1912";
//        arr[2] = "1892";
//        arr[3] = "1234";
//        cavityMap(arr);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String tests = br.readLine();
            for(int j=0; j<Integer.parseInt(tests); j++){
                String bigString = br.readLine();
                String numSubStr = br.readLine();
                for(int i=0; i<Integer.parseInt(numSubStr); i++){
                    String smallString = br.readLine();
                    getSubStrCount(bigString, smallString);
                    getProtocol(bigString);
                }
            }
           
        } catch (IOException ex) {
        }
//        
    }
    
}
