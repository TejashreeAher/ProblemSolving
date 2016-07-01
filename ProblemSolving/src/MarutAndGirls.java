
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
public class MarutAndGirls {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int numQual = Integer.parseInt(br.readLine());
            String[] mQualities = br.readLine().split(" ");
            List<String> mQual = new ArrayList();
            mQual.addAll(Arrays.asList(mQualities));
            int numGirls = Integer.parseInt(br.readLine());
            int count=0;
            for(int i=0; i<numGirls; i++){
                String[] gQual = br.readLine().split(" ");
                List<String> gQualList = new ArrayList<>();
                gQualList.addAll(Arrays.asList(gQual));
                if(gQualList.containsAll(mQual)){
                    count++;
                }
            }
            System.out.println(count);
            
        } catch (IOException ex) {
            Logger.getLogger(MarutAndGirls.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
