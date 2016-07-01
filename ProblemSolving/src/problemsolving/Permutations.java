/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package problemsolving;

/**
 *
 * @author tejashree.aher
 * this is not complete
 */
public class Permutations {
    
    private static void swap(Character[] a, int index1, int index2){
      Character s = a[index1];
      a[index1] = a[index2];
      a[index2] = s;
    }
    
    private static void printArray(Character[] a){
        for (Character a1 : a) {
            System.out.print(a1);
        }
        System.out.println();
    }
    
    private static void getAllPermutations(Character[] a, int start, int end){
        if(a == null || a.length == 0){
            return;
        }
        if(start ==  end){
            printArray(a);
        }else{
            for(int i=start; i<=end; i++){
                swap(a, start, end);
                getAllPermutations(a, start+1, end);
                swap(a, start, end);
            }
        }
        
        
    }
    
    public static void main(String[] args){
        Character[] a = {'A', 'B', 'C'};
        getAllPermutations(a, 0, 2);
    }
    
}
