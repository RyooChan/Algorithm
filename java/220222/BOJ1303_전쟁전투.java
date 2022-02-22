import java.util.*;

class info{
    int x;
    int y;
    info(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class MyClass {
    public static int N, M;
    public static int map[][];
    public static boolean check[][];
    
    public static int xMove[] = {-1, 1, 0, 0};
    public static int yMove[] = {0, 0, -1, 1};
    
    public static int white = 0;
    public static int black = 0;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        M = sc.nextInt();
        N = sc.nextInt();
        
        map = new int[N][M];
        check = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            String input = sc.next();
            for(int j=0; j<M; j++){
                if(input.charAt(j)=='W') map[i][j] = 1;
                else map[i][j] = 0;
            }
        }
        Queue<info> mans = new LinkedList<>();
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(check[i][j]) continue;
                check[i][j] = true;
                mans.add(new info(i, j));
                int cnt = 1;
                int now = map[i][j];
                while(!mans.isEmpty()){
                    info info = mans.poll();
                    int x = info.x;
                    int y = info.y;
                    for(int k=0; k<4; k++){
                        int xTo = x + xMove[k];
                        int yTo = y + yMove[k];
                        if(xTo<0 || yTo<0 || yTo>=M || xTo>=N) continue;
                        if(check[xTo][yTo] || now != map[xTo][yTo]) continue;
                        check[xTo][yTo] = true;
                        cnt++;
                        mans.offer(new info(xTo, yTo));
                    }
                }
                if(now==1) white += cnt*cnt;
                else black += cnt*cnt;
            }
        }
        System.out.println(white + " " + black);
        
    }
}
