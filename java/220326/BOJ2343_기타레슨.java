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
        
        int left = max;
        int right = 100000001;
        
        while(left <= right){
            int mid = (left+right)/2;
            int sum = 0;
            int cnt = 1;
            
            for(int i=0; i<N; i++){
                sum += num[i];
                if(sum > mid){
                    cnt++;
                    sum = num[i];
                }
            }
            
            if(cnt > M){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
//        System.out.println(right+1);  // 둘다 가능.
        System.out.println(left);
    }
}

// https://hello-backend.tistory.com/126
