import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int num[] = new int[N];
        
        for(int i=0; i<N; i++) num[i] = sc.nextInt();
        
        long dp[][] = new long[N][21];
        
        dp[0][num[0]] = 1;
        for(int i=1; i<N-1; i++){
            for(int j=0; j<21; j++){
                if(dp[i-1][j]==0) continue;
                int plus = num[i] + j;
                int minus = j - num[i];
                
                if(plus>=0 && plus<=20){
                    dp[i][plus] += dp[i-1][j];
                }
                if(minus>=0 && minus<=20){
                    dp[i][minus] += dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N-2][num[N-1]]);
    }
}

// https://hello-backend.tistory.com/139
