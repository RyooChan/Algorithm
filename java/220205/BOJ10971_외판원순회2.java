import java.util.*;

public class Main {
    public static int N;
    public static int city[][];
    public static boolean check[];
    public static int ans = Integer.MAX_VALUE;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        city = new int[N][N];
        check = new boolean[N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                city[i][j] = sc.nextInt();
            }
        }
        
        for(int i=0; i<N; i++){
            check[i] = true;
            find(i, i, 0, 0);
            check[i] = false;
        }
        System.out.println(ans);
    }
    public static void find(int start, int now, int depth, int sum){
        if(depth == N-1){
            if(city[now][start]==0) return;
            sum += city[now][start];
            ans = Math.min(ans, sum);
            return;
        }
        for(int i=0; i<N; i++){
            if( check[i] || city[now][i]==0 ) continue;
            check[i] = true;
            sum += city[now][i];
            find(start, i, depth+1, sum);
            sum -= city[now][i];
            check[i] = false;
        }
    }
}
