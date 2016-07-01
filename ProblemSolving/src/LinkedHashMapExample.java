
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tejashree.aher
 */
public class LinkedHashMapExample {
    private static final int SIZE = 5;
    private static Map<Integer, String> map = Collections.synchronizedMap(new LinkedHashMap<Integer, String>(){
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > SIZE;
     }
    });
    
    private static synchronized void addToMap(int key, String value){
        map.put(key, value);
    }
    
   
    
    public static void main(String[] args){
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        for(int i : map.keySet()){
            System.out.println(i + ": "+ map.get(i));
        }
        System.out.println("*******************************");
        System.out.println("AFter removing 5");
        map.remove(5);
        for(int i : map.keySet()){
            System.out.println(i + ": "+ map.get(i));
        }
        System.out.println("*******************************");
        System.out.println("AFter adding 9");
        map.put(9, "nine");
        map.put(1, "one");
        for(int i : map.keySet()){
            System.out.println(i + ": "+ map.get(i));
        }
        
    }
    
}
