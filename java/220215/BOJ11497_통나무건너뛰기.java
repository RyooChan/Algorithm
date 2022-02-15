import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        while(T-->0){
            int N = sc.nextInt();
            int num[] = new int[N];
            int numTo[] = new int[N];
            
            for(int i=0; i<N; i++){
                num[i] = sc.nextInt();
            }
            Arrays.sort(num);
            
            int ans = 0;
            int cnt = 0;
            for(int i=0; i<N; i+=2){
                numTo[cnt++] = num[i];
            }
            cnt = N-1;
            for(int i=1; i<N; i+=2){
                numTo[cnt--] = num[i];
            }
            
            for(int i=1; i<N; i++){
                ans = Math.max(ans, Math.abs(numTo[i] - numTo[i-1]));
            }
            ans = Math.max(ans, Math.abs(numTo[0] - numTo[N-1]));
            System.out.println(ans);
        }

    }
}
