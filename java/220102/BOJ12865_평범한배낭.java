import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int bags[][] = new int[N+1][2];
        int fun[][] = new int[N+1][K+1];
        
        for(int i=1; i<=N; i++){
            int weight = sc.nextInt();
            int val = sc.nextInt();
            bags[i][0] = weight;
            bags[i][1] = val;
        }
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                if(j < bags[i][0]) fun[i][j] = fun[i-1][j];
                else{
                    fun[i][j] = Math.max( fun[i-1][j], fun[i-1][j-bags[i][0]] + bags[i][1] );
                }
                // System.out.println(i + "의 " + j + "번째 : " + fun[i][j]);
            }
        }
        System.out.println(fun[N][K]);
    }
}
