import java.util.*;

public class MyClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int dp[] = new int[N+1];
        
        if(N<=4){
            if(N==1) System.out.println("CY");
            else if(N==2) System.out.println("SK");
            else if(N==3) System.out.println("CY");
            else System.out.println("SK");
            return;
        }
        
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 0;
        
        for(int i=5; i<N+1; i++){
            int win = dp[i-4] + dp[i-3] + dp[i-1];
            if(win>0){
                dp[i] = 0;
            }else{
                dp[i] = 1;
            }
        }
        
        if(dp[N]==1) System.out.println("CY");
        else System.out.println("SK");
        
    }
}
