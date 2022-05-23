import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        
        long dp[] = new long[num.length()+1];
        
        if(num.charAt(0)=='0'){
            System.out.println(0);
        }else{
            dp[0] = 1;
            dp[1] = 1;
            for(int i=2; i<num.length()+1; i++){
                char now = num.charAt(i-1);
                char before = num.charAt(i-2);
                if(now=='0') {
                    if(!(before=='1' || before=='2')){
                        System.out.println(0);
                        return;
                    }else{
                        dp[i] = dp[i-2];
                        continue;
                    }
                }
                int number = Integer.parseInt(before+""+now);
                
                dp[i] = dp[i-1];
                if(before=='0'){
                    dp[i] = dp[i-1];
                    continue;
                }
                if(number<=26 && number>=1){
                    dp[i] += dp[i-2];
                }
                dp[i] %= 1000000;
            }
            System.out.println(dp[num.length()]);
        }

    }
}
