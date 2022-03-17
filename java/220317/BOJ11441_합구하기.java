import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int num[] = new int[N];
        int sum[] = new int[N+1];
        
        for(int i=0; i<N; i++){
            num[i] = sc.nextInt();
            sum[i+1] = num[i] + sum[i];
        } 
        
        int T = sc.nextInt();
        while(T-->0){
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(sum[end] - sum[start-1]);
        }

    }
}
