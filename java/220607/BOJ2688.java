import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        long dp[][] = new long[65][10];
        
        for(int i=0; i<10; i++){
            dp[1][i] = 1;
        }
        
        for(int i=2; i<65; i++){
            for(int j=0; j<10; j++){
                for(int k=j; k<10; k++){
                    dp[i][j] += dp[i-1][k];
                }
            }
        }
        
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int N = sc.nextInt();
            long ans = 0;
            for(int i=0; i<10; i++) ans += dp[N][i];
            sb.append(ans + "\n");
        }
        System.out.println(sb.toString());
    }
}
