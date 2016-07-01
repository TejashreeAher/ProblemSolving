
import java.util.concurrent.LinkedBlockingQueue;
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
public class BlockingQueue {
     private static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(5);
     
     public static void main(String[] args){
         for(int i=0; i<15; i++){
             queue.offer(i);
         }
         for(int i=0; i<queue.size(); i++){
             try {
                 System.out.println(queue.take());
             } catch (InterruptedException ex) {
                 System.out.println("Caught Excepton");
                 Logger.getLogger(BlockingQueue.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
     }
    
}
