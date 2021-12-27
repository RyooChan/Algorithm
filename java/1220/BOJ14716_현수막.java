import java.util.*;

public class Main {
    public static int xMove[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static int yMove[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    
    public static int N;
    public static int M;
    
    public static int map[][];
    public static boolean check[][];
    
    public static int ans = 0;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        map = new int[N][M];
        check = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==1 && !check[i][j]) {
                    ans++;
                    DFS(i, j);
                }
            }
        }
        System.out.println(ans);
    }
    
    public static void DFS(int x, int y){
        if(x<0 || y<0 || x>=N || y>=M) return;
        if(map[x][y]==0 || check[x][y]) return;
        check[x][y] = true;
        for(int i=0; i<8; i++){
            int xTo = x + xMove[i];
            int yTo = y + yMove[i];
            DFS(xTo, yTo);
        }
    }
    
}
