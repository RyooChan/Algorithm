import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int line[][] = new int[N][2];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<2; j++){
                line[i][j] = sc.nextInt();
            }
        }
        
		Arrays.sort(line, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if(a[0]<b[0]) return -1;
				else if(a[0]>b[0]) return 1;
				return 0;
			}
		});
		
		int dp[] = new int[N];
		Arrays.fill(dp, 1);
		
		int max = 0;
		
		for(int i=0; i<N; i++){
		    for(int j=0; j<i; j++){
		        if(line[i][1] > line[j][1]){
		            dp[i] = Math.max(dp[i], dp[j]+1);
		            max = Math.max(max, dp[i]);
		        }
		    }
		}
		
		int ans = N - max;
		System.out.println(ans);
        
    }
}

// https://hello-backend.tistory.com/135
