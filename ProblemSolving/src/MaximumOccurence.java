import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MaximumOccurence {
    
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        HashMap<String, Integer> n = new HashMap<>(N);
        int max=0;
        int maxIndex=0;
        String[] l = br.readLine().split(" ");
        for(int j=0; j<l.length; j++){
            int k= n.containsKey(l[j]) ? n.get(l[j]) : 0;
            n.put(l[j], k+1);
            if(k+1>max){
                max=k;
                maxIndex= j;
            }
        }
        System.out.println(l[maxIndex]);
    }
}