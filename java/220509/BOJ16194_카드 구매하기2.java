import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cards[] = new int[N+1];
        int dp[] = new int[N+1];
        
        for(int i=1; i<N+1; i++) cards[i] = sc.nextInt();
        
        for(int i=1; i<N+1; i++){
            dp[i] = cards[i];
            for(int j=1; j<i; j++){
                dp[i] = Math.min(dp[i], (dp[j]+dp[i-j]));
            }
        }
        System.out.println(dp[N]);
    }
}
