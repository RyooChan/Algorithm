import java.util.*;

class info{
    int x;
    int y;
    int move;
    char now;
    info(int x, int y, int move, char now){
        this.x = x;
        this.y = y;
        this.move = move;
        this.now = now;
    }
}
public class Main {
    public static Queue<info> q = new LinkedList<>();
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int xMove[] = {-1, 1, 0, 0};
        int yMove[] = {0, 0, -1, 1};
        
        int R = sc.nextInt();
        int C = sc.nextInt();
        
        char maze[][] = new char[R][C];
        
        int jihoonX = -1;
        int jihoonY = -1;
        for(int i=0; i<R; i++){
            String input = sc.next();
            for(int j=0; j<C; j++){
                char now = input.charAt(j);
                maze[i][j] = now;
                if(now == 'F'){
                    q.add(new info(i, j, 0, 'F'));
                } 
                else if(now == 'J'){
                    jihoonX = i;
                    jihoonY = j;
                }
            }
        }
        
        if( jihoonX==0 || jihoonY==0 || jihoonX==R-1 || jihoonY==C-1 ){
            System.out.println(1);
            return;
        }
        
        q.add(new info(jihoonX, jihoonY, 1, 'J'));
        
        while(!q.isEmpty()){
            int xTo;
            int yTo;
            info info = q.poll();
            int x = info.x;
            int y = info.y;
            int move = info.move;
            char now = info.now;
            
            if(now == 'J'){
                move++;
            } 
            
            for(int i=0; i<4; i++){
                xTo = x + xMove[i];
                yTo = y + yMove[i];
                if(xTo<0 || yTo<0 || xTo>=R || yTo>=C) continue;
                if(maze[xTo][yTo] != '.') continue;
                maze[xTo][yTo] = now;
                if( now=='J' && ( xTo==0 || yTo==0 || xTo==R-1 || yTo==C-1 ) ){
                    System.out.println(move);
                    return;
                }
                q.add(new info(xTo, yTo, move, now));
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}

// https://hello-backend.tistory.com/125
