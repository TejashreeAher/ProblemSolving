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
 */
public class MaximumSum {
    static private Map<String, Integer> indexToMaxSumMap = new HashMap<String, Integer>();
    static int sum;
    public static int A[];
    public static int B[];
    
    static int getMaxSum(int currentIndex, int size, Boolean currentArray){
        if(size == 0)
            return 0;
        int arrayNumber = currentArray?1:0;
        String keyArr = String.valueOf(arrayNumber)+":"+ String.valueOf(currentIndex);
        if(indexToMaxSumMap.containsKey(keyArr) && indexToMaxSumMap.get(keyArr) != null){
            System.out.println("Present in map for:" + currentIndex +" sum found: "+ indexToMaxSumMap.get(keyArr));
            return indexToMaxSumMap.get(keyArr);
        }
        int[] nextArray = getNextArray(currentArray);
        int[] currArray = getCurrArray(currentArray);
        if(currentIndex == size-1){
            int max = max(currArray[currentIndex], nextArray[currentIndex]);
            indexToMaxSumMap.put(keyArr, max);
             return max;
        }
        int tempSum = getMaxSum(currentIndex+1, size, currentArray);
        if(currArray[currentIndex] > nextArray[currentIndex+1]){
            sum = currArray[currentIndex] + tempSum;
        }else{
            sum = currArray[currentIndex] + max(tempSum, getMaxSum(currentIndex+1, size, !currentArray));
        }
        System.out.println("Adding in map for:" + currentIndex + "; sum is: "+ sum);
        indexToMaxSumMap.put(keyArr, sum);
        return sum;
    }
    
    static int max(int i, int j){
        return i>j?i:j;
    }

    static int[] getNextArray(Boolean currArray){
         return currArray?A:B;       
    }

    static int[] getCurrArray(Boolean currArray){
         return currArray?B:A;       
    }

    static int getMax(int size){
        return max(getMaxSum(0, size, false), getMaxSum(0, size, true));
    }   
    
    public static void main(String[] args){
        A= new int[]{1, 98, 22, 12};
        B = new int[]{23, 12, 1, 88};
        System.out.println(getMax(4));
    }
    
}
