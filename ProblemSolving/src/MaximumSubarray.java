
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class MaximumSubarray {
    
    private static int getMaxContiguous(int[] a){
        if(a== null || a.length == 0){
            return 0;
        }
        int max_sum = a[0];
        int max_sum_here = a[0];
        for(int i=1; i<a.length; i++){
            int tempMaxSumHere = max_sum_here;
            max_sum_here = max_sum_here + a[i];
            if(max_sum_here < 0){
                max_sum_here = (max_sum_here > tempMaxSumHere)?max_sum_here:tempMaxSumHere;
            }
            max_sum = (max_sum > max_sum_here)?max_sum:max_sum_here;
        }
        return max_sum;
    }
    
    private static int getMax(int[] a){
        boolean hasPositive = false;
        int minimum = a[0];
        for(int i=0; i<a.length; i++){
            if(a[i] >= 0){
                hasPositive = true;
                break;
            }
            minimum = (minimum < a[i])?minimum:a[i];
        }
        if(!hasPositive){
           return minimum; 
        }
        int sum = (a[0]>0)?a[0]:0;
        for(int i=1; i<a.length; i++){
            if(a[i] > 0){
                sum = sum + a[i];
            }
        }
        return sum;
    }
    
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int tests = Integer.parseInt(br.readLine());
            for(int i=0; i<tests; i++){
                int n = Integer.parseInt(br.readLine());
                int[] a = new int[n];
                String[] aStr = br.readLine().split("\\s");
                for(int j=0; j<n; j++){
                    int num = Integer.parseInt(aStr[j]);
                    a[j] = num;
                }
                System.out.println(getMaxContiguous(a) + " "+getMax(a));
            }
        } catch (IOException ex) {
            Logger.getLogger(MaximumSubarray.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
