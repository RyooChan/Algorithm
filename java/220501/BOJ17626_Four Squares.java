import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int dp[] = new int[N+1];
        
        dp[1] = 1;
        
        for(int i=2; i<=N; i++){
            int min = Integer.MAX_VALUE;
            
            for(int j=1; j*j<=i; j++){
                int num = i - j * j;
                min = Math.min(min, dp[num]);
            }
            
            dp[i] = min+1;
        }
        System.out.println(dp[N]);
        
    }
}
