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
    public static int M;
    
    public static int map[][];
    public static int distance[][];
    public static boolean check[][];
    public static Queue<info> house = new LinkedList<>();
    
    public static int ans = Integer.MAX_VALUE;
    public static int houseNum;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        map = new int[N][N];
        distance = new int[N][N];
        check = new boolean[N][N];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int input = sc.nextInt();
                if(input==1){
                    house.add(new info(i, j));
                }
                map[i][j] = input;
            }
        }
        
        houseNum = house.size();
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 2){
                    for(int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);
                    check[i][j] = true;
                    bf(1, i, j);
                    check[i][j] = false;
                }
            }
        }
        System.out.println(ans);
        
    }
    public static void bf(int cnt, int x, int y){
        
        for(int i=0; i<houseNum; i++){
            info info = house.poll();
            int housex = info.x;
            int housey = info.y;
            distance[housex][housey] = Math.min(distance[housex][housey], ( Math.abs(x-housex) + Math.abs(y-housey) ));
            house.add(new info(housex, housey));
        }
        
        if(cnt==M){
            int nowDistance = 0;
            for(int i=0; i<houseNum; i++){
                info info = house.poll();
                int housex = info.x;
                int housey = info.y;
                nowDistance += distance[housex][housey];
                house.add(new info(housex, housey));
            }
            ans = Math.min(ans, nowDistance);
            return;
        }
        
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==2 && !check[i][j]){
                    check[i][j] = true;
                    bf(cnt+1, i, j);
                    check[i][j] = false;
                }
            }
        }
    }
}
