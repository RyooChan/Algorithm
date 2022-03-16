longimport java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        while( T --> 0){
            int N = sc.nextInt();
            long num[] = new long[N];
            for(int i=0; i<N; i++) num[i] = sc.nextInt();
            
            long ans = 0;
            long max = 0;
            
            for(int i=N-1; i>=0; i--){
                if(num[i] > max){
                    max = num[i];
                }else{
                    ans += (max - num[i]);
                }
            }
            System.out.println(ans);
            
        }

    }
}
