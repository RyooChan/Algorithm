import java.util.*;

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      
      while(N-->0) {
        int cnt = sc.nextInt();
        int coins[] = new int[cnt];
        
        int dp[] = new int[10001];
        
        for(int i=0; i<cnt; i++) {
          coins[i] = sc.nextInt();
        }

        // 0원 만드는 방법은 1개
        dp[0] = 1;
        
        int target = sc.nextInt();

        // 작은 숫자부터 해야 중복이슈가 없음
        for(int i=0; i<cnt; i++) {
          // 7원이라 치면 7, 8, 9 원에 도달하는 방법은 0, 1, 2원에서 7원 더하면 되니까 저렇게 함
          for(int j=coins[i]; j<=target; j++) { 
            dp[j] += dp[j - coins[i]];
          }
        }
        
        System.out.println(dp[target]);
      }
  }
}
