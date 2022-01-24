import java.util.*;

class info{
    int x;
    int y;
    int time;
    info(int x, int y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {
    public static ArrayList<info> Wholevirus = new ArrayList<>();
    public static int wholeArea = 0;
    public static info virusList[];
    public static int xMove[] = {-1, 1, 0, 0};
    public static int yMove[] = {0, 0, -1, 1};
    
    public static int N, M;
    public static int ans = Integer.MAX_VALUE;
    
    public static int map[][];
    public static boolean canbe = false;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        virusList = new info[N];
        
        map = new int[N][N];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j]==2){
                    Wholevirus.add(new info(i, j, 0));      // 바이러스 입력
                }else if(map[i][j]==0){
                    wholeArea++;
                }
            }
        }
        activateVirus(0, 0);
        
        if(canbe)System.out.println(ans);
        else System.out.println(-1);
    }
    
    static void activateVirus(int first, int nowCnt) {
        if (nowCnt == M) {
            virusTime();
            return;
        }
        for (int i=first; i<Wholevirus.size(); i++) {
            virusList[nowCnt] = Wholevirus.get(i);
            activateVirus(i+1, nowCnt+1);
        }
    }
    
    static void virusTime(){
        int contaminate = 0;
        int timeSpent = -1;
        Queue<info> infect = new LinkedList<>();
        boolean check[][] = new boolean[N][N];
        
        for(int i=0; i<M; i++){
            info info = virusList[i];
            check[info.x][info.y] = true;
            infect.add(info);
        } 
        
        while(!infect.isEmpty()){
            info info = infect.poll();
            
            int x = info.x;
            int y = info.y;
            int time = info.time;
            
            
            timeSpent = Math.max(timeSpent, time);
            if(map[x][y]==0) contaminate++;
            
            if(contaminate == wholeArea){
                canbe = true;
                ans = Math.min(timeSpent, ans);
                return;
            }
            
            for(int i=0; i<4; i++){
                int xTo = x + xMove[i];
                int yTo = y + yMove[i];
                
                if( xTo<0 || xTo>=N || yTo<0 || yTo>=N ) continue;
                if( check[xTo][yTo] || map[xTo][yTo]==1 ) continue;
                check[xTo][yTo] = true;
                
                infect.add(new info(xTo, yTo, time+1));
            }
        }
    }
    
}
