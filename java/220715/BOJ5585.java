import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        String A = sc.next();
        String B = sc.next();
        
        int dp[][] = new int[A.length()+1][B.length()+1];
        int ans = 0;
        
        for(int i=1; i<=A.length(); i++){
            for(int j=1; j<=B.length(); j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
    				dp[i][j] = dp[i-1][j-1] + 1;
    				ans = Math.max(ans, dp[i][j]);
                }
            }
        }

      System.out.println(ans);
    }
}
