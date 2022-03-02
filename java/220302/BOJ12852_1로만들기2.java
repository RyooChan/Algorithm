import java.util.*;


class info{
    int num;
    String make;
    info(int num, String make){
        this.num = num;
        this.make = make;
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        info[] dp = new info[N+1];
        
        dp[1] = new info(0, "1");
        
        for(int i=2; i<N+1; i++){
            int cnt = Integer.MAX_VALUE;
            int before = 0;
            if(i%3==0){
                cnt = Math.min(cnt, dp[i/3].num);
                before = i/3;
            }
            if(i%2==0){
                if(cnt > dp[i/2].num){
                    cnt = dp[i/2].num;
                    before = i/2;
                }
            }
            if(cnt>dp[i-1].num) before = i-1;
            
            dp[i] = new info(dp[before].num+1, i+" "+dp[before].make);
            
        }
        System.out.println(dp[N].num);
        System.out.println(dp[N].make);
    }
}
