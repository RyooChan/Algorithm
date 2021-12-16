import java.util.*;

public class Main {
    
    public static int xMove[] = {-1, 1, 0, 0};
    public static int yMove[] = {0, 0, -1, 1};
    public static char map[][];
    public static boolean check[][];
    
    public static int N;
    public static int M;
    
    public static int wolfNum = 0;
    public static int sheepNum = 0;
    
    public static int wolf = 0;
    public static int sheep = 0;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        map = new char[N][M];
        check = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            String input = sc.next();
            map[i] = input.toCharArray();
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!check[i][j] && map[i][j]!='#'){
                    wolfNum = 0;
                    sheepNum = 0;
                    DFS(i, j);
                    if(wolfNum<sheepNum) sheep += sheepNum;
                    else wolf += wolfNum;
                } 
            }
        }
        System.out.printf("%d %d", sheep, wolf);
        
    }
    public static void DFS(int x, int y){
        if(x<0 || y<0 || x>=N || y>=M) return;
        if(check[x][y] || map[x][y]=='#') return;
        check[x][y] = true;
        
        if(map[x][y]=='k') sheepNum++;
        else if(map[x][y]=='v') wolfNum++;
        
        for(int i=0; i<4; i++){
            int xTo = x+xMove[i];
            int yTo = y+yMove[i];
            
            DFS(xTo, yTo);
        }
    }
}
