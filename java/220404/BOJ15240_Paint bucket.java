import java.util.*;

public class Main {
    public static int N, M;
    public static int xMove[] = {-1, 1, 0, 0};
    public static int yMove[] = {0, 0, -1, 1};
    public static int map[][];
    public static boolean check[][];
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        map = new int[N][M];
        check = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            String input = sc.next();
            char[] chr = input.toCharArray();
            for(int j=0; j<M; j++){
                int aa = chr[j] - '0';
                map[i][j] = aa;
            }
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        int num = sc.nextInt();
        
        dfs(x, y, num, map[x][y]);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(map[i][j]);
            }sb.append("\n");
        }
        System.out.println(sb.toString());
        
    }
    public static void dfs(int x, int y, int num, int startNum){
        if(x<0 || y<0 || x>=N || y>=M) return;
        if(check[x][y] || startNum != map[x][y]) return;
        
        check[x][y] = true;
        map[x][y] = num;
        
        for(int i=0; i<4; i++){
            int xTo = x + xMove[i];
            int yTo = y + yMove[i];
            
            dfs(xTo, yTo, num, startNum);
        }
        
    }
}
