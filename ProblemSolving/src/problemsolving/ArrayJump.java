/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package problemsolving;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tejashree.aher
 */
public class ArrayJump {
    public int solution(int[] A) {
        Map<Integer, Boolean> presentNumbersMap = new HashMap<Integer, Boolean>();
        int i=0;
        int numberOfSteps = 0;
        while(i >= 0 && i < A.length){
            if(presentNumbersMap.containsKey(i)){
                return -1;
            }
            presentNumbersMap.put(i, Boolean.TRUE);
            i = i + A[i];
            numberOfSteps++;
        }
        numberOfSteps += 1;
        return numberOfSteps;
    }
    
}

