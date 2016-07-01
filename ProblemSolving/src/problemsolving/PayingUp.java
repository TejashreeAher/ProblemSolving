/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package problemsolving;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tejashree.aher
 * http://www.codechef.com/problems/MARCHA1/
 */
public class PayingUp {

    /**
     * @param args the command line arguments
     */
    
    private static boolean getResult(List<Integer> list, int startIndex, int endIndex, int m){
        if(m == 0) return true;
        while(startIndex <= endIndex){
            return (getResult(list, startIndex+1, endIndex, m-list.get(startIndex)) ||  getResult(list, startIndex+1, endIndex, m));
        }
        return false;
       
    }
    
    public static void main(String[] args) {
        
        List<Integer> list = new ArrayList<>(3);
        list.add(1);
        list.add(5);
        list.add(5);
        list.add(10);
        list.add(10);
        list.add(17);
list.add(6);
list.add(4);
list.add(998);
list.add(254);
list.add(137);
list.add(259);
list.add(153);
list.add(154);
list.add(3);
list.add(28);
list.add(19);
list.add(123);
list.add(542);
list.add(857);
list.add(23);
list.add(687);
list.add(35);
list.add(99);
list.add(999);
        
        System.out.println("Result : "+ getResult(list, 0, 19, 132));
        
    }
    
}
