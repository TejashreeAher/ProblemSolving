/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tejashree.aher
 */
public class GridWalking {
    
    private static int sum(int[] pos,  int m, int n){
        int count = 0;
        for (int i=0; i<pos.length; i++){
            if(pos[i] < 0 || pos[i] > n-1){
                return 0;
            }
        }
        for(int i=0; i<pos.length; i++){
            int next = pos[i]+1; 
            int prev = pos[i]-1;
            pos[i] = next;
            count+=function(pos, m, n);
            pos[i] = prev;
            count+=function(pos, m, n);
        }
    }
    
    private static int function(int[] pos, int m, int n){
        return 0;
    }
}
