import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int box[] = new int[N+1];
        int dp[] = new int[N+1];
        int max = 1;
        Arrays.fill(dp, 1);
        
        for(int i=1; i<N+1; i++) box[i] = sc.nextInt();
        
        for(int i=1; i<N+1; i++){
            for(int j=1; j<i; j++){
                if(box[i]>box[j]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                    max = Math.max(max, dp[i]);
                } 
            }
        }
        System.out.println(max);
    }
}
