import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int map[][] = new int[N][M];
        char toChr[][] = new char[N][M];
        for(int i=0; i<N; i++){
            String input = sc.next();
            toChr[i] = input.toCharArray();
            for(int j=0; j<M; j++) map[i][j] = toChr[i][j] - '0';
        }
        
        int ans = -1;
        int xMove[] = {-1, 1, 0, 0};
        int yMove[] = {0, 0, -1, 1};
        boolean before[][] = new boolean[N][M];
        boolean after[][] = new boolean[N][M];
        
        
        Queue<info> you = new LinkedList<>();
        // before[0][0] = true;
        // after[0][0] = true;
        you.add(new info(0, 0, false, 1));
        while(!you.isEmpty()){
            info info = you.poll();
            
            int x = info.x;
            int y = info.y;
            boolean brake = info.brake;
            int move = info.move;
            // System.out.println("x : " + x + ", y : " + y);
            if(x==N-1 && y==M-1){
                ans = move; 
                break;
            }
            
            if(x<0 || y<0 || x>=N || y>=M) continue;
            
            if(!brake){
                if(before[x][y]) continue;
                before[x][y] = true;
                if(map[x][y] == 1) brake = true;
            }else{
                if(after[x][y] || map[x][y]==1) continue;
                after[x][y] = true;
            }
            for(int i=0; i<4; i++){
                int xTo = x + xMove[i];
                int yTo = y + yMove[i];
                you.add(new info(xTo, yTo, brake, move+1));
            }
            
        }
      System.out.println(ans);
    }
}
class info{
    int x;
    int y;
    boolean brake;
    int move;
    info(int x, int y, boolean brake, int move){
        this.x = x;
        this.y = y;
        this.brake = brake;
        this.move = move;
    }
}

// 풀이 https://hello-backend.tistory.com/95
