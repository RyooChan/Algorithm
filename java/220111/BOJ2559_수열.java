import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int arr[] = new int[N];
        for(int i=0; i<N; i++) arr[i] = sc.nextInt();
        
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<N-K+1; i++){
            int sum=0;
            for(int j=0; j<K; j++){
                sum += arr[i+j];
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
        
    }
}
