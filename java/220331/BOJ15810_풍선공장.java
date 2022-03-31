import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int num[] = new int[N];
		int max = 0;
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st2.nextToken());
            max = Math.max(max, num[i]);
        } 
        
        long left = 0;
        long right = (long)max*M;
        long ans = 0;
        
        while(left <= right){
            long mid = (left+right)/2;
            long sum = 0;
            
            for(int i=0; i<N; i++){
                sum += (long)mid/num[i];
            }
            
            if(sum < M){
                left = mid+1;
            }else{
                right = mid-1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }
}


// https://hello-backend.tistory.com/128
