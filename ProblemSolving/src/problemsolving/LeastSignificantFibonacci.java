/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package problemsolving;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tejashree.aher
 */
public class LeastSignificantFibonacci {
    
    static Map<Integer, BigInteger> numToFibonacci = new HashMap<Integer, BigInteger>();
    
    private static int getNumDigits(BigInteger n){
        int count = 0;
        while (n.compareTo(BigInteger.ZERO) == 1){
            n = n.divide(BigInteger.TEN);
            count++;
        }
//        while(n > 0){
//            n=n/10;
//            count++;
//        }
        return count;
    }
    
    private static BigInteger getFibValue(int n){
        if(n < 0 ){
            return BigInteger.ZERO;
        }
        if(numToFibonacci.containsKey(n)){
            return numToFibonacci.get(n);
        }
        if(n == 0){
            numToFibonacci.put(0, BigInteger.ZERO);
            return BigInteger.ZERO;
        }
        if(n == 1){
            numToFibonacci.put(1, BigInteger.ONE);
            return BigInteger.ZERO;
        }
        BigInteger value = getFibValue(n-1).add(getFibValue(n-2));
        numToFibonacci.put(n, value);
        return value;
    }
    
    private static BigInteger solution(int N){
        BigInteger value = getFibValue(N);
        int numDigits = getNumDigits(value);
        if(numDigits < 6){
            return value;
        }
        int count = numDigits - 6;
        int i=0;
        while(i < count){
            long powerNumber = (long) Math.pow(10, numDigits-1);
            value = value.mod(BigInteger.valueOf(powerNumber));
//                    value % powerNumber;
            numDigits--;
            i++;
        }
        return value;
    }
    
    
    public static void main(String[] args){
        System.out.println(solution(100));
    }
}
