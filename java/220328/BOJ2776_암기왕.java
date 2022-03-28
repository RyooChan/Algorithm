import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(T-->0){
            HashSet<Integer> hs = new HashSet<>();
            int N = Integer.parseInt(br.readLine());
            
		    StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) hs.add(Integer.parseInt(st.nextToken()));
            
            int M = Integer.parseInt(br.readLine());
            
		    st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                if(hs.contains(Integer.parseInt(st.nextToken()))) sb.append(1 + "\n");
                else sb.append(0 + "\n");
            }
        }
        System.out.println(sb);
        
    }
}
