import java.util.*;

public class Main {
    public static int map[][];
    public static boolean check[][];
    public static int N;
    public static int M;
    public static int xMove[] = {-1, 1, 0, 0};
    public static int yMove[] = {0, 0, -1, 1};
    public static Queue<info> BFS = new LinkedList<>();
    
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
        
        boolean exist = true;
        Queue<info> BFS = new LinkedList<>();
        int cnt = 0;
        int ans = 0;
        while(exist && cnt<2){
            exist = false;
            check = new boolean[N][M];
            ans++;
            cnt = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j]!=0 && !check[i][j]){
                        cnt++;
                        exist = true;  
                        DFS(i, j);
                    } 
                }
            }
            map = melt();
        }
        if(!exist) ans = 1;
        System.out.println(ans-1);
    }
    public static void DFS(int x, int y){
        check[x][y] = true;
        BFS.add(new info(x, y, map[x][y]));
        for(int i=0; i<4; i++){
            int xTo = x+xMove[i];
            int yTo = y+yMove[i];
            if(xTo>=N || xTo<0 || yTo>=M || yTo<0) continue;
            if(map[xTo][yTo]==0 || check[xTo][yTo]) continue;
            DFS(xTo, yTo);
        }
    }
    public static int[][] melt(){
        int mapChanger[][] = new int[N][M];
        while(!BFS.isEmpty()){
            info info = BFS.poll();
            int x = info.x;
            int y = info.y;
            int height = info.height;
            for(int i=0; i<4; i++){
                int xTo = x+xMove[i];
                int yTo = y+yMove[i];
                if(xTo>=N || xTo<0 || yTo>=M || yTo<0) continue;
                if(map[xTo][yTo]==0) height--;
            }
            if(height<0) height=0;
            mapChanger[x][y] = height;
        }
        return mapChanger;
    }
}
class info{
    int x;
    int y;
    int height;
    info(int x, int y, int height){
        this.x = x;
        this.y = y;
        this.height = height;
    }
}
