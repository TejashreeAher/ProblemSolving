/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tejashree.aher
 */
class Solution {
    public static int solution(int[] A, int N) {
        if(A == null || A.length == 0 || N == -1 | N ==0){
           return 0; 
        }
       int desiredSum = (N+1)*(N+2) / 2;
       int sum = 0;
       System.out.println("sum is : "+ desiredSum);
       for(int i=0; i<A.length; i++){
           sum+=A[i];
       }
       return desiredSum - sum;
    }
    
    public static void main(String[] args){
        int[] A = {2,3,1,5};
        System.out.println(solution(A,4));
    }
}
