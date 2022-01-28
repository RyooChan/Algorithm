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
    public static int N;
    public static int map[][];
    public static boolean check[][];
    public static int xMove[] = {-1, 1, 0, 0};
    public static int yMove[] = {0, 0, -1, 1};
    
    public static int min_gap, max_gap;
    public static Queue<info> cities = new LinkedList<>();
    public static Queue<info> united = new LinkedList<>();
    
    public static int sum = 0;
    public static int cnt = 0;
    
    public static boolean moveExist;
    
    public static int ans = -1;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        min_gap = sc.nextInt();
        max_gap = sc.nextInt();
        
        map = new int[N][N];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }
        
        moveExist = true;
        
        while(moveExist){
            moveExist = false;
            check = new boolean[N][N];
            
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(check[i][j]) continue;
                    sum = 0;
                    cnt = 0;
                    cities.add(new info(i, j));
                    BFS();
                    if(united.size() > 1) mapChanger();
                }
            }
            ans++;
        }
        System.out.println(ans);
    }
    public static void BFS(){
        united.clear();
        while(!cities.isEmpty()){
            info info = cities.poll();
            
            int x = info.x;
            int y = info.y;
            
            check[x][y] = true;
            sum += map[x][y];
            cnt++;
            united.add(new info(x, y));
            
            for(int i=0; i<4; i++){
                int xTo = x + xMove[i];
                int yTo = y + yMove[i];
                
                if(xTo<0 || xTo>=N || yTo<0 || yTo>=N) continue;
                else if(check[xTo][yTo]) continue;
                else if( Math.abs(map[x][y] - map[xTo][yTo]) > max_gap || Math.abs(map[x][y] - map[xTo][yTo]) < min_gap ) continue;
                check[xTo][yTo] = true;
                cities.add(new info(xTo, yTo));
            }
            
        }
    }
    public static void mapChanger(){
        moveExist = true;
        int mid = sum/cnt;
        while(!united.isEmpty()){
            info info = united.poll();
            map[info.x][info.y] = mid;
        }
    }
}

// 해설 https://hello-backend.tistory.com/101
