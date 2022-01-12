import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
	    
	    int map[][] = new int[N][M];
	    ArrayList<Integer> heights = new ArrayList<>();
	    
	    int min = Integer.MAX_VALUE;
	    int max = Integer.MIN_VALUE;
	    
	    for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
	        for(int j=0; j<M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
	            min = Math.min(min, map[i][j]);
	            max = Math.max(max, map[i][j]);
	        }
	    }
	    
	    int height = 0;
	    int ans = Integer.MAX_VALUE;
	    
	    for(int i=min; i<=max; i++){
	        int time = 0;
	        int blocks = B;
	        
	        for(int j=0; j<N; j++){
	            for(int k=0; k<M; k++){
	                int heightDiff = map[j][k]-i;
	                
	                if(heightDiff>0){
	                    blocks += heightDiff;
	                    time += 2*heightDiff;
	                }else{
	                    blocks += heightDiff;
	                    time -= 1*heightDiff;
	                }
	            }
	        }
	        if(time<=ans && blocks>=0){
	            ans = time;
	            if(height < i) height = i;
	        }
	    }
		System.out.println(ans + " " + height);
		
    }
}
