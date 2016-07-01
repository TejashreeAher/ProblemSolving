/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package problemsolving;

/**
 *
 * @author tejashree.aher
 * Lights Off is a puzzle game consisting of an n x n grid of lights. At the beginning of the game, some of the lights are switched on. 
 * When a light is pressed, this light and the four adjacent lights are toggled, i.e., they are switched on if they were off, and switched off otherwise. 
 * The purpose of the game is to switch all the lights off.
 */
public class LightsOff {
    private static Integer[][] A;
    
    private static boolean checkIfResultReached(Integer[][] A, int size){
        for(int i =0; i< size; i++){
            for(int j=0; j<size; j++){
                if(A[i][j] == 1){
                    return false;
                }
            }
        }
        return true;
    }
    
    /***
     * @args
     * i is the row of the light to be pressed
     * j is the column
     * A is the current condition of the game
     * **/
    private static void pressLight(Integer[][] A, int i, int j, int size){
        if(i >= size ||  j >= size ){
            return;
        }
        A[i][j] = A[i][j] xor A[i][j];
     }
    
    public static void main(String[] args){
        int size = 3;
        A = new Integer[size][size];
    }
}
