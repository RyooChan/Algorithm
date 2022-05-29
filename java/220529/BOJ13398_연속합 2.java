import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();

        int num[] = new int[N+1];
        long dp[][] = new long[N+1][2];

        for(int i=0; i<N; i++) num[i] = sc.nextInt();
        
        dp[0][0] = dp[0][1] = num[0];
        
        long ans = num[0];
        for(int i=1; i<N; i++){
            dp[i][0] = Math.max(dp[i-1][0]+num[i], num[i]);
            dp[i][1] = Math.max(dp[i-1][1]+num[i], dp[i-1][0]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(ans);
    }
}
