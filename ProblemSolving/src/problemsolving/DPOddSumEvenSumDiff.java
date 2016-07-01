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
Count total number of N digit numbers such that the difference between sum of even and odd digits is 1

Given a number n, we need to count total number of n digit numbers such that the sum of even digits is 1 more than the sum of odd digits. Here even and odd means positions of digits are like array indexes, for exampl, the leftmost (or leading) digit is considered as even digit, next to leftmost is considered as odd and so on.

Example

Input:  n = 2
Output: Required Count of 2 digit numbers is 9
Explanation : 10, 21, 32, 43, 54, 65, 76, 87, 98.

Input:  n = 3
Output: Required Count of 3 digit numbers is 54
Explanation: 100, 111, 122, ......, 980
Src: http://www.geeksforgeeks.org/count-total-number-of-n-digit-numbers-such-that-the-difference-between-the-sum-of-even-digits-and-odd-digits-is-1/
 * @author tejashree.aher
 */
public class DPOddSumEvenSumDiff {
    static Map<String, Integer> map = new HashMap<String, Integer>();
    
    private static int getTotalNos(int n, int startIndex, int difference){
        if(map.containsKey(n-startIndex+":"+difference)){
//            System.out.println("Found in map for "+ (n-startIndex) +" and "+ difference);
            return map.get(n-startIndex+":"+difference);
        }
        int totalNums = 0;
        if(startIndex == n && difference == 0){
            return 1;
        }
        if(startIndex == n && difference != 0){
            return 0;
        }
        for(int i=0; i<10; i++){
            if(startIndex == 0 && i ==0){
                continue;
            }
            totalNums = totalNums + getTotalNos(n, startIndex+1, i-difference);
        }
//        System.out.println("Adding in map for "+ (n-startIndex) + " and "+ difference);
        map.put(n-startIndex+":"+difference, totalNums);
        return totalNums;
    }
    
    public static void main(String[] args){
        System.out.println(getTotalNos(3, 0,1));
    }
}
