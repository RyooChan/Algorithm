import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int ans = 0;
        
        while(true) {
            int bottle = N + ans;
            int cnt = 0;
            
            while(bottle > 0) {
                if(bottle % 2 != 0) cnt++;
                bottle /= 2;
            }
            
            if(cnt <= K)
                break;
            
            ans++;
        }

      System.out.println(ans);
    }
}
