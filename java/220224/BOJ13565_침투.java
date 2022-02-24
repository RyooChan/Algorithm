import java.util.*;

public class Main {
    
    public static int xMove[] = {-1, 1, 0, 0};
    public static int yMove[] = {0, 0, 1, -1};
    public static char map[][];
    public static boolean check[][];
    
    public static int N;
    public static int M;
    
    public static boolean answer = false;
    
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
        
        for(int j=0; j<M; j++){
            if(!check[0][j] && map[0][j]=='0'){
                DFS(0, j);
            } 
        }
        if(answer) System.out.println("YES");
        else System.out.println("NO");
        
    }
    public static void DFS(int y, int x){
        if(y<0 || x<0 || y>=N || x>=M) return;
        if(check[y][x] || map[y][x]=='1') return;
        check[y][x] = true;
        if(y==N-1) answer = true;
        
        for(int i=0; i<4; i++){
            int yTo = y+yMove[i];
            int xTo = x+xMove[i];
            
            DFS(yTo, xTo);
        }
    }
}
