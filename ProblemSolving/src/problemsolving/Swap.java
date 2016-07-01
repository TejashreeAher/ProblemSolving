/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package problemsolving;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 *
 * @author tejashree.aher
 */
public class Swap {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String l = br.readLine();
		String[] p = l.split(" ");
		System.out.println(p[1]+" "+p[0]);
    }
}
    
}
