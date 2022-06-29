 java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int num[] = new int[N];
        
        for(int i=0; i<N; i++) num[i] = sc.nextInt();
        Arrays.sort(num);
        
        long ans = 0;
        for(int i=1; i<N+1; i++){
            ans += Math.abs(num[i-1]-i);
        }
        
        System.out.println(ans);
        
    }
}
