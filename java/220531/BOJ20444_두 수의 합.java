import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] num = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(num);
            
            int start = 0;
            int end = N-1;
            
            int midNow = (int)2*100000000;
            int ans = 1;
            while(start < end){
                int sum = num[start] + num[end];
                
                if(Math.abs(sum-K) == midNow){
                    ans++;
                }else if(Math.abs(sum-K) < midNow){
                    ans = 1;
                    midNow = Math.abs(sum-K);
                }
                
                if(sum>K){
                    end--;
                }else{
                    if(sum==K) end--;
                    start++;
                }
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }
}

// 자바 8로 하면 터짐… 11로 해야한다.

