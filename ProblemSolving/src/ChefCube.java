
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tejashree.aher
 */
public class ChefCube {
    private static ArrayList<Character> removeDup(ArrayList<Character> A){
        HashMap<Character, Boolean> isCharPresent = new HashMap<Character, Boolean>();
        int i=0;
        int j=0;
        if(A == null){
            return null;
        }
        while(A.get(j) != null){
            if(isCharPresent.get(A.get(j))){
                A.set(i, A.get(j));
                i++;
                j++;
                isCharPresent.put(A.get(j), Boolean.TRUE);
            }else{
                while(isCharPresent.get(A.get(j))){
                    A.set(i, null);
                    j++;
                }
                 A.set(i, A.get(j));
           }
            if(i != j){
                A.set(j, null);
            }
        }
        return A;
    }
    
    
    private static void ArrayDiff(int[] A, int lengthA, int[] B, int lengthB){
        ///assumption: A and B have only postitive numbers, therefore -1 is used in A to show absence of number
        if( A== null || B == null){
            return;
        }
        int i=0;
        int j=0;
        while( i < lengthA && j<lengthA){
            if(A[i] != -1|| A[i]<B[j]){
                i++;
            }else if(A[i] > B[j]){
                j++;
            }else if(A[i] == B[j]){
                ///time to remove duplicates
                if(i < lengthA-1){
                    A[i] = A[i+1];
                    shiftAToLeft(A, i);
                    j++;
                }
            }
        }
    }
    
    private static void shiftAToLeft(int[] A, int i){
        for(int j=i; j<A.length-1; j++){
            A[j] = A[j+1];
        }
        A[A.length-1] = -1; //last number is -1
    }
}
