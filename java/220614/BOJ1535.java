import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int health[] = new int[N];
        int joy[] = new int[N];
        
        for(int i=0; i<N; i++){
            health[i] = sc.nextInt();
        }
        
        for(int i=0; i<N; i++){
            joy[i] = sc.nextInt();
        }
        
        int dp[] = new int[100];
        for(int i=0; i<N; i++){
            for(int j=99; j>=health[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-health[i]] + joy[i]);
            }
        }
        
        System.out.println(dp[99]);
    }
}
