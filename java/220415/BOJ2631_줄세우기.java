import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int student[] = new int[N];
        int dp[] = new int[N];
        Arrays.fill(dp, 1);
        
        for(int i=0; i<N; i++) student[i] = sc.nextInt();
        
        int max = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(student[i] > student[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        
        int ans = N - max;
        System.out.println(ans);
        
    }
}

// https://hello-backend.tistory.com/136
