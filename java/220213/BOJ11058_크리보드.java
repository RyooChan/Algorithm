import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        long process[] = new long[N+1];
        
        for (int i=1; i<=Math.min(N, 6); i++) {
            process[i] = i;
        }

        for (int i=7; i<=N; i++) {
            for (int j=2; j<=5; j++) {
                process[i] = Math.max(process[i-(j+1)] * j, process[i]);
            }
        }
        
        System.out.println(process[N]);
        
    }
}
