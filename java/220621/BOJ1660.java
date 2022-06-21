import java.util.*;

class info{
    int x;
    int y;
    int k;
    int move;
    info(int x, int y, int k, int move){
        this.x = x;
        this.y = y;
        this.k = k;
        this.move = move;
    }
}

public class Main {
    public static int xMove[] = {-1, 1, 0, 0};
    public static int yMove[] = {0, 0, -1, 1};
    
    public static int xHorse[] = {2, 2, -2, -2, 1, 1, -1, -1};
    public static int yHorse[] = {1, -1, 1, -1, 2, -2, 2, -2};
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        Queue<info> q = new LinkedList<>();
        
        int kIn = sc.nextInt();
        int W = sc.nextInt();
        int H = sc.nextInt();
        
        int map[][] = new int[H][W];
        boolean check[][][] = new boolean[H][W][kIn+1];
        
        for(int i=0; i<W; i++){
            for(int j=0; j<H; j++){
                map[j][i] = sc.nextInt();
            }
        }
        
        q.add(new info(0, 0, kIn, 0));
        check[0][0][0] = true;
        
        while(!q.isEmpty()){
            info info = q.remove();
            int x = info.x;
            int y = info.y;
            int k = info.k;
            int move = info.move;
            
            if(x==H-1 && y==W-1){
                System.out.println(move);
                return;
            }
            
            for(int i=0; i<4; i++){
                int xTo = x + xMove[i];
                int yTo = y + yMove[i];
                
                if(xTo<0 || yTo<0 || xTo>=H || yTo>=W) continue;
                if(map[xTo][yTo]==1 || check[xTo][yTo][k]) continue;
                check[xTo][yTo][k] = true;
                q.add(new info(xTo, yTo, k, move+1));
            }
            
            if(k>0)
            for(int i=0; i<8; i++){
                int xTo = x + xHorse[i];
                int yTo = y + yHorse[i];
                
                if(xTo<0 || yTo<0 || xTo>=H || yTo>=W) continue;
                if(map[xTo][yTo]==1 || check[xTo][yTo][k-1]) continue;
                check[xTo][yTo][k-1] = true;
                q.add(new info(xTo, yTo, k-1, move+1));
            }
            
        }
        System.out.println(-1);
        
    }
}
