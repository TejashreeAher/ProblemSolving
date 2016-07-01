import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author tejashree.aher
 */
public class DiagonalDifference {
    
     public static void main(String[] args) {
         
         
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String tests = br.readLine();
            int sum1 = 0;
            int sum2 = 0;
            for(int j=0; j<Integer.parseInt(tests); j++){
               int[][] arr = new int[Integer.parseInt(tests)][Integer.parseInt(tests)];
               String[] rowArr = br.readLine().split(" ");
               sum1 = sum1+Integer.parseInt(rowArr[j]);
               sum2  = sum2+Integer.parseInt(rowArr[Integer.parseInt(tests) - j - 1]);
            }
            int res = sum1-sum2;
           System.out.println(res>0?res:(res*(-1)));
        } catch (IOException ex) {
        }
    }
    
}
