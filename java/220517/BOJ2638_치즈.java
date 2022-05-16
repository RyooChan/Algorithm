import java.util.*;

public class Main {
    public static int N, M;
    public static int xMove[] = {-1, 1, 0, 0};
    public static int yMove[] = {0, 0, -1, 1};
    
    public static int map[][];
    public static int newMap[][];
    public static boolean check[][];
    
    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
            }
        }
        
        int ans = -1;
        boolean isMelt = true;
        while(isMelt){
            isMelt = false;
            newMap = new int[N][M];
            check = new boolean[N][M];
            ans++;
            DFS(0, 0);
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(newMap[i][j] >= 2){
                        map[i][j] = 0;
                        isMelt = true;
                    }       
                }
            }
        }
        System.out.println(ans);
    

    }
    public static void DFS(int x, int y){
        check[x][y] = true;
        
        for(int i=0; i<4; i++){
            int xTo = x + xMove[i];
            int yTo = y + yMove[i];
            
            if(xTo<0 || yTo<0 || xTo>=N || yTo>=M) continue;
            if(map[xTo][yTo] == 1){
                newMap[xTo][yTo]++;
                continue;
            } 
            if(check[xTo][yTo]) continue;
            
            DFS(xTo, yTo);
        }
    }
}
