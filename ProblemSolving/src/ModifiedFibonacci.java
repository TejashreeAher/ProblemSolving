
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
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
public class ModifiedFibonacci {
    
    private static BigInteger getFib(BigInteger first, BigInteger second, long index){
        if(index < 0){
            return BigInteger.valueOf(0);
        }
        if(index == 1){
            return first;
        }
        if(index == 2){
            return second;
        }
        BigInteger b1 = getFib(first, second, index-1);
        BigInteger b2 = getFib(first, second, index-2);
        return (b1.multiply(b1)).add(b2);
    }
    
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            String[] arr = line.split(" ");
            if(arr.length < 3){
                return;
            }
            long first = Long.valueOf(arr[0]);
            long second = Long.valueOf(arr[1]);
            long index = Long.valueOf(arr[2]);
             System.out.println(getFib(BigInteger.valueOf(first), BigInteger.valueOf(second), index));
        
            
        } catch (IOException ex) {
            Logger.getLogger(ModifiedFibonacci.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.println(getFib(BigInteger.ONE, BigInteger.ONE, 20));
    }    
}
