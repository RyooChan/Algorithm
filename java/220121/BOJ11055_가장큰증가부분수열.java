import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int num[] = new int[N+1];
        int sum[] = new int[N+1];
        
        for(int i=1; i<=N; i++) num[i] = sc.nextInt();
        
        sum[1] = num[1];
        int ans = sum[1];
        
        for(int i=2; i<=N; i++){
            for(int j=0; j<i; j++){
                if(num[j] < num[i]){
                     sum[i] = Math.max(sum[i], sum[j] + num[i]);
                }
            }
            ans = Math.max(sum[i], ans);
        }
        System.out.println(ans);
    }
}
