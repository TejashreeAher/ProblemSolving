
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tejashree.aher
 */
public class ValentineShopping {
    
    private static float getPrice(String[] succDiscounts){
        float basePrice = 100;
        for (String succDiscount : succDiscounts) {
            basePrice = basePrice - ((basePrice)*Integer.parseInt(succDiscount))/100;
        }
        return basePrice;
    }
    
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String tests = br.readLine();
            for(int i=0; i<Integer.parseInt(tests); i++){
                String[] line = br.readLine().split(" ");
                String nstr = line[0];
                String mStr = line[1];
                
                String result = "";
                StringBuilder sb = new StringBuilder();
                for(int n =1; n <= Integer.parseInt(nstr); n++){
                    float minForJ = -1;
                    int minIndex = 0;
                    for(int m=1; m <= Integer.parseInt(mStr); m++){
                        //get min of m for n
                        String[] mthDiscForN = new String[3];
                        mthDiscForN = br.readLine().split(" ");
                        float priceHere = getPrice(mthDiscForN);
                        if(priceHere < minForJ || minForJ == -1){
                            minForJ = priceHere;
                            minIndex = m;
                        }
                    }
                    sb.append(result).append(minIndex).append(" ");
                    if(n == Integer.parseInt(nstr)){
                        sb.substring(0, sb.length()-1);
                    }
                }
                System.out.println(sb.toString());
            }
            
        } catch (IOException ex) {
        }
    }
    
}
