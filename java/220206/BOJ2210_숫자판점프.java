import java.util.*;

public class MyClass {
    public static final int N = 5;
    
    public static ArrayList<String> nums = new ArrayList<>();
    public static int ans = 0;
    
    public static int map[][];
    public static int xMove[] = {-1, 1, 0, 0};
    public static int yMove[] = {0, 0, -1, 1};
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        map = new int[N][N];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                DFS(i, j, map[i][j] + "", 0);
            }
        }
        
        System.out.println(ans);
    }
    public static void DFS(int x, int y, String num, int cnt){
        if(cnt==N){
            if(!nums.contains(num)){
                nums.add(num);
                ans++;
            }
            return;
        }
        
        for(int i=0; i<4; i++){
            int xTo = x + xMove[i];
            int yTo = y + yMove[i];
            
            if(xTo<0 || xTo>=N || yTo<0 || yTo>=N) continue;
            DFS(xTo, yTo, num+map[xTo][yTo], cnt+1);
        }
        
    }
}
