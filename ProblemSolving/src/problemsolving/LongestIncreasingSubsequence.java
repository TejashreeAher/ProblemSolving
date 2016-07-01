/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package problemsolving;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tejashree.aher
 * L(i) = 1 + max(L(j)) such that i>j and array[i] > array[j], if no such condition then L(i) = 1;
 */
public class LongestIncreasingSubsequence {
    static Map<Integer, Integer> indexToLISMap = new HashMap<Integer, Integer>();
    ///longest increasing subsequence ending at index including index
    private static int getLongestIncreasingSubsequence(int[] array, int index){
        if(indexToLISMap.containsKey(index)){
            System.out.println("Found in map for index : "+ index);
            return indexToLISMap.get(index);
        }
        if(index == 0){
            indexToLISMap.put(index, 1);
            return 1;
        }
        if(index < 0 || array == null){
            return 0;
        }
        int maxTillNow = 0;
        for(int i=0; i<index; i++){
            if(array[i] < array[index]){
                 int maxHere = getLongestIncreasingSubsequence(array, i);
                if(maxHere > maxTillNow){
                    maxTillNow = maxHere;
                }
            }
        }
        indexToLISMap.put(index, 1+maxTillNow);
        return 1 + maxTillNow;
    }
    
    
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,4,11,23,12,3};
        int maxTillNow =0;
        for(int i=0; i<array.length; i++){
            int maxHere = getLongestIncreasingSubsequence(array, i);
            if(maxHere > maxTillNow){
                maxTillNow = maxHere;
            }
        }
        System.out.println(maxTillNow);
    }
}
