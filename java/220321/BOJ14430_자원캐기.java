import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int map[][] = new int[N][M];
        int dp[][] = new int[N][M];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
            }
        }
        
        dp[0][0] = map[0][0];
        for(int i=1; i<N; i++) dp[i][0] = dp[i-1][0] + map[i][0];
        for(int i=1; i<M; i++) dp[0][i] = dp[0][i-1] + map[0][i];
        
        for(int i=1; i<N; i++){
            for(int j=1; j<M; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + map[i][j];
            }
        }
        System.out.println(dp[N-1][M-1]); 
    }
}
