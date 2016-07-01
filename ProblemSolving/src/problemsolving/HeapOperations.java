/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package problemsolving;

/**
 *
 * @author tejashree.aher
 */
public class HeapOperations {
    
    //this assumes that subtrees already satisfy heap condition O(lg(n))
    private static void maxHeapify(Integer[] A, int index, int size){
        int largestIndex = index;
        int leftIndex = index*2+1;
        int rightIndex = leftIndex+1;
        if(leftIndex < size){
            if(A[leftIndex] > A[index]){
                largestIndex = leftIndex;
            }else{
                largestIndex = index;
            }
        }
        if(rightIndex < size){
            if(A[rightIndex] > A[largestIndex]){
                largestIndex = rightIndex;
            }
        }
        if(largestIndex != index){
            //swap largest and index
            Integer temp = A[index];
            A[index] = A[largestIndex];
            A[largestIndex] = temp;
            maxHeapify(A, largestIndex, size);
        }
    }
    
    //O(n) -> more tighter bound
    private static void buildHeap(Integer[] A){
        for(int i=A.length-1; i>=0; i--){
            maxHeapify(A, i, A.length);
        }
    }
    
    //O(nlg(n))
    private static void heapSort(Integer[] A){
        int size = A.length;
        for(int i=A.length-1; i>0; i--){
            Integer temp = A[i];
            A[i] = A[0];
            A[0] = temp;
            size = size -1;
            maxHeapify(A, 0, size);
        }
    }
    
    private static Integer extractMax(Integer[] A){
        Integer max = A[0];
        Integer temp = A[A.length-1];
        A[A.length-1] = A[0];
        A[0] = temp;
        maxHeapify(A, 0, A.length-1);
        return max;
    }
    
    private static void increaseKet(Integer[] A, int index, int newValue){
        if(A[index] > newValue){
            return; ///we only cater to greater values
        }
        while(index > 0 && A[index] > A[index/2]){
            ////value is greater than parent's value, exchange with parent and agianc heck if parent violates the heap condition
            Integer temp = A[index/2];
            A[index] = A[index/2];
            A[index/2] = temp;
            index= index/2;
        } 
    }
    
    public static void main(String[] args){
        Integer[] A = new Integer[10];
        A[0] = Integer.valueOf(16);
        A[1] = Integer.valueOf(4);
        A[2] = Integer.valueOf(10);
        A[3] = Integer.valueOf(14);
        A[4] = Integer.valueOf(7);
        A[5] = Integer.valueOf(9);
        A[6] = Integer.valueOf(3);
        A[7] = Integer.valueOf(2);
        A[8] = Integer.valueOf(8);
        A[9] = Integer.valueOf(1);
        
        buildHeap(A);
//        heapSort(A);
        System.out.println(extractMax(A));
        for(Integer i: A){
            System.out.println(i);
        }
        
    }
    
}
