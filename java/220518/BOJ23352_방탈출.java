import java.util.*;

class info{
    int x;
    int y;
    int move;
    info(int x, int y, int move){
        this.x = x;
        this.y = y;
        this.move = move;
    }
}
public class Main {
    public static int N, M;
    public static int map[][];
    public static boolean check[][];
    
    public static int start;
    public static int route = 0;
    public static int ans=0;
    
    public static int xMove[] = {-1, 1, 0, 0};
    public static int yMove[] = {0, 0, -1, 1};
    
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
                if(map[i][j] != 0){
                    check = new boolean[N][M];
                    check[i][j] = true;
                    start = map[i][j];
                    BFS(i, j);
                }
            }
        }
        System.out.println(ans);
    }
    public static void BFS(int xs, int ys){
        Queue<info> q = new LinkedList<>();
        
        q.add(new info(xs, ys, 0));
        
        while(!q.isEmpty()){
            
            info info = q.remove();
            int x = info.x;
            int y = info.y;
            int move = info.move;
            int end = map[x][y];
            
            if(move >= route){
                if(move > route){
                    ans = start + end;
                }else{
                    ans = Math.max(ans, start+end);
                }
                route = move;
            }
            
            for(int i=0; i<4; i++){
                int xTo = x + xMove[i];
                int yTo = y + yMove[i];
                
                if(xTo<0 || yTo<0 || xTo>=N || yTo>=M) continue;
                if(check[xTo][yTo] || map[xTo][yTo]==0) continue;
                check[xTo][yTo] = true;
                
                q.add(new info(xTo, yTo, move+1));
            }
        }
    }
}

// https://hello-backend.tistory.com/134
