import java.util.*;

public class Main {
    public static int N;
    public static int jump[][];
    public static long map[][];
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        jump = new int[N][N];
        map = new long[N][N];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                jump[i][j] = sc.nextInt();
            }
        }
        
        map[0][0] = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i==N-1&&j==N-1) continue;
                if(i+jump[i][j] < N) map[i+jump[i][j]][j] += map[i][j];
                if(j+jump[i][j] < N) map[i][j+jump[i][j]] += map[i][j];
            }
        }
        System.out.println(map[N-1][N-1]);
    }
    
}
