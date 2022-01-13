import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        long num[][] = new long[N+1][N+1];
        
        for(int i=1; i<N+1; i++){
            for(int j=0; j<=i; j++){
                if (i==j || j==0) 
                    num[i][j]=1; 
                else 
                    num[i][j]=( num[i-1][j-1] + num[i-1][j] ) % 10007;
            }
        }
        System.out.println(num[N][K]);
    }
}
