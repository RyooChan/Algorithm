import java.util.*;

class info{
    int x;
    int y;
    info(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static int N, M;
    public static int map[][];
    public static boolean check[][];
    public static Queue<info> finder = new LinkedList<>();
    public static int xMove[] = {-1, 1, 0, 0};
    public static int yMove[] = {0, 0, -1, 1};
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        map = new int[N][M];
        // check = new boolean[N+1][M+1];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        int ansBefore = 0;
        while(true){
            boolean can = false;
            ans++;
            
            check = new boolean[N][M];
            finder.add(new info(0, 0));
            BFS();
            ansBefore = melt();
            
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j] == 1){
                        can = true;
                    } 
                }
            }
            if(!can) break;
            
        }
        System.out.println(ans);
        System.out.println(ansBefore);
    }
    public static void BFS(){
        while(!finder.isEmpty()){
            info info = finder.remove();
            int x = info.x;
            int y = info.y;
            
            for(int i=0; i<4; i++){
                int xTo = x + xMove[i];
                int yTo = y + yMove[i];
                
                if(xTo<0 || xTo>=N || yTo<0 || yTo>=M) continue;
                if(check[xTo][yTo]) continue;
                check[xTo][yTo] = true;
                
                if(map[xTo][yTo] == 1){
                    map[xTo][yTo] = 2;
                }else if(map[xTo][yTo] == 0){
                    finder.add(new info(xTo, yTo));
                }
            }
        }
    }
    public static int melt(){
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 2){
                    map[i][j] = 0;
                    cnt++;
                } 
            }
        }
        return cnt;
    }
}

// 해설 https://hello-backend.tistory.com/102
