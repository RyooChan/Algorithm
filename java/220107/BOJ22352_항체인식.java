import java.util.*;

public class Main {
    public static int map[][];
    public static int compare[][];
    public static boolean check[][];
    
    public static int N, M;
    
    public static int xMove[] = {-1, 1, 0, 0};
    public static int yMove[] = {0, 0, -1, 1};
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        String ans = "YES";
        
        map = new int[N][M];
        compare = new int[N][M];
        check = new boolean[N][M];
        int diffInfo[] = new int[4];    // x, y, num
        boolean diff = false;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                compare[i][j] = sc.nextInt();
                if(compare[i][j] != map[i][j] && !diff){
                    diff = true;
                    diffInfo[0] = i;
                    diffInfo[1] = j;
                    diffInfo[2] = map[i][j];
                    diffInfo[3] = compare[i][j];
                }
            }
        }
        
        if(diff) DFS(diffInfo[0], diffInfo[1], diffInfo[2], diffInfo[3]);
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]!=compare[i][j]) ans = "NO";
            }
        }
        System.out.println(ans);
        
    }
    public static void DFS(int x, int y, int color, int toColor){
        if(x<0 || y<0 || x>=N || y>=M) return;
        if(check[x][y] || map[x][y]!=color) return;
        check[x][y] = true;
        map[x][y] = toColor;
        for(int i=0; i<4; i++){
            int xTo = x + xMove[i];
            int yTo = y + yMove[i];
            DFS(xTo, yTo, color, toColor);
        }
    }
}


// 해설 https://hello-backend.tistory.com/98
