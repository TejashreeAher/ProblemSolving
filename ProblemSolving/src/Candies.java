
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
//https://www.hackerrank.com/challenges/candies/forum
/**
 *
 * @author tejashree.aher
 */
public class Candies {
    
    private static int getMax(int i, int j){
       return  i<j?j:i;
    }
    private static int getMinCandies(int n, int[] rating){
        int result = 0;
        if(n <= 0){
            return 0;
        }
        int[] numCandies = new int[n]; ///or same as size of rating array
        for(int i=0; i<numCandies.length; i++){
            numCandies[i] = 1; //initialise as all children must have one candy
        }
        for(int i=0; i<numCandies.length-1; i++){
            if(rating[i+1] > rating[i]){
                numCandies[i+1] = numCandies[i]+1;
            }
        }
        for(int i=n-1; i>0; i--){
            if(rating[i-1] > rating[i]){
                numCandies[i-1] = getMax(numCandies[i-1], numCandies[i]+1);
            }
        }
        for(int i=0; i<numCandies.length; i++){
            result += numCandies[i];
        }
        return result;
    }
    
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] rating = new int[n];
            for(int i=0; i<n; i++){
                rating[i] = Integer.parseInt(br.readLine());
            }
//        int[] rating = {1,2,2};
            System.out.println(getMinCandies(n, rating));
        } catch (IOException ex) {
            Logger.getLogger(Candies.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
