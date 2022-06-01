import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        int dp[];
        while(T-->0){
            int N = sc.nextInt();
            
            
            ArrayList<Integer> arr = new ArrayList();
            for(int i=0; i<N; i++) arr.add(sc.nextInt());
            int money = sc.nextInt();
        
            dp = new int[money+1];
            dp[0] = 1;
            
            for(Integer nowCoin : arr){
                for(int j=nowCoin; j<=money; j++){
                    dp[j] += dp[j - nowCoin];
                }
            }
            System.out.println(dp[money]);
        }
        
    }
}
