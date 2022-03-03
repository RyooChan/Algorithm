import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int dp[] = new int[N+1];
        
        int vipNum = sc.nextInt();
        HashSet<Integer> vip = new HashSet<>();
        
        for(int i=0; i<vipNum; i++) vip.add(sc.nextInt());
        
        if(N<=2)System.out.println(N);
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i<N+1; i++){
            if(vip.contains(i) || vip.contains(i-1)){
                dp[i] = dp[i-1];   
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        System.out.println(dp[N]);
    }
}

// 해설 https://hello-backend.tistory.com/123
