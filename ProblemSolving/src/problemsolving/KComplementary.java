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
public class KComplementary {
    private static Node root;
    
    private static class Node {
        long value;
        int size;
        Node left;
        Node right;
        public Node(long n){
            this.value = n;
            this.left = null;
            this.right = null;
            this.size=1;
        }
    }
    
    private static void addNode(long n, Node node){
        if(n == node.value){
            node.size=node.size+1;
            System.out.println(n + " already present in tree. Incremeting size");
            return;
        }
        if(n < node.value){
            if(node.left == null){
                Node newNode = new Node(n);
                node.left = newNode;
                System.out.println("Left of "+ node.value +" is : "+newNode.value);
            }else{
                addNode(n, node.left);
            }
        }else{
            if(node.right == null){
                Node newNode = new Node(n);
                node.right = newNode;
                System.out.println("Right of "+ node.value +" is : "+newNode.value);
            }else{
                addNode(n, node.right);
            }
        }
    }
    
    private static void buildTree(int[] A){
        root = new Node(A[0]);
        for(int i=1; i < A.length; i++){
            addNode(Long.valueOf(A[i]), root);
        }
    } 
    
    private static int searchTree(long number, Node root){
        if(root == null){
            return 0;
        }
        if(root.value == number){
            return root.size;
        }
        if(number < root.value){
            return searchTree(number, root.left);
        }else{
            return searchTree(number, root.right);
        }
    }
    
    public static int solution(int K, int[] A) {
        int numPairs = 0;
        long k = Long.valueOf(K);
        buildTree(A);
        for(int i = 0; i<A.length; i++){
            long searchNumber = k-Long.valueOf(A[i]);
            System.out.println("Searching for "+searchNumber);
            int num = searchTree(searchNumber, root);
            System.out.println("Pair for  : "+ A[i] +" "+searchNumber + "is found  "+ num +" times");
            numPairs = numPairs+num;
            
        }
        return numPairs;
    }
    
    public static void main(String[] args){
        int[] A = {1,8,-3,0,1,3,-2,4,5};
        System.out.println(solution(6, A));
    }
}
