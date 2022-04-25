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
    public static int xMove[] = {-1, 1, 0, 0};
    public static int yMove[] = {0, 0, -1, 1};
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        char map[][] = new char[N][M];
        boolean check[][] = new boolean[N][M];
        Queue<info> mover = new LinkedList<>();
        
        for(int i=0; i<N; i++){
            String input = sc.next();
            map[i] = input.toCharArray();
            for(int j=0; j<M; j++){
                if(map[i][j]=='I') mover.add(new info(i, j));
            }
        }
        
        int ans = 0;
        while(!mover.isEmpty()){
            info info = mover.remove();
            int x = info.x;
            int y = info.y;
            if(map[x][y]=='X' || check[x][y]) continue;
            
            if(map[x][y] == 'P') ans++;
            check[x][y] = true;
            
            for(int i=0; i<4; i++){
                int xTo = x + xMove[i];
                int yTo = y + yMove[i];
                
                if(xTo<0 || xTo>=N || yTo<0 || yTo>=M) continue;
                
                mover.add(new info(xTo, yTo));
            }
            
        }
        if(ans!=0) System.out.println(ans);
        else System.out.println("TT");
    }
}
