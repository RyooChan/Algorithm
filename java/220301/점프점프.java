import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();

        int num[] = new int[N+1];
        int route[] = new int[N+1];
        for(int i=1; i<N+1; i++) num[i] = sc.nextInt();
        
        Arrays.fill(route, 1001);
        route[1] = 0;
        
        for(int i=1; i<=N; i++){
            if(route[i]==1001) continue;
            int go = num[i];
            for(int j=1; j<=go; j++){
                if(i+j>N) break;
                route[i+j] = Math.min(route[i+j], route[i]+1);
            }
        }
        if(route[N]==1001) System.out.println(-1);
        else System.out.println(route[N]);
    
    }
}
