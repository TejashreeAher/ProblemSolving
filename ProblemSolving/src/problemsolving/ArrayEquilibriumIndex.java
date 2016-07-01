/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package problemsolving;

/**
 *An equilibrium index of this array is any integer P such that 0 ≤ P < N and the sum of elements of lower indices is equal to the sum of elements of higher indices, i.e.

    A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].
 * @author tejashree.aher
 */
public class ArrayEquilibriumIndex {
    
    public int solution(int[] A) {
        if(A == null || A.length == 0){
            return -1;
        }
        long sum1=0;
        long sum2=0;
        for(int i=1; i<A.length; i++){
            sum2 = sum2+A[i];
        }
        int p=0;
        boolean isFound=false;
        while(p < A.length){
            if(p == A.length-1 && sum1 != sum2){
                break;
            }
            if(sum1 == sum2){
                isFound = true;
                break;
            }
            sum1=sum1+A[p];
            p+=1;
            sum2 = sum2-A[p];
        }
        if(isFound){
            return p;
        }else{
            return -1;
        }
    }
    
   public static void main(String[] args){
       int a = 2147483647;
       System.out.print(a+1);
       
   }
    
}
