import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int xMove[] = {-1, 1, 0, 0};
        int yMove[] = {0, 0, -1, 1};
        
        Queue<info> coor = new LinkedList<>();
        int ans = -1;
        
        int R = sc.nextInt();
        int C = sc.nextInt();
        
        char map[][] = new char[R][C];
        boolean check[][] = new boolean[R][C];
        
        for(int i=0; i<R; i++){
            String input = sc.next();
            map[i] = input.toCharArray();
        }
        
        
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]=='*') coor.add(new info(i, j, '*', 0));
            }
        }
        
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]=='S') coor.add(new info(i, j, 'S', 0));
            }
        }
        
        while(!coor.isEmpty()){
            info info = coor.poll();
            int x = info.x;
            int y = info.y;
            char start = info.start;
            int cnt = info.cnt;
            
            if(x<0 || y<0 || x>=R || y>=C) continue;
            if(start=='*'){
                if(map[x][y]=='S') ;
                else if(check[x][y] || map[x][y]=='D' || map[x][y]=='X') continue;
                
            }
            else if(check[x][y] || map[x][y]=='*' || map[x][y]=='X') continue;
            
            if(map[x][y]=='D' && start=='S'){
                ans = cnt;
                break;
            }
            check[x][y] = true;
            map[x][y] = start;
            for(int i=0; i<4; i++){
                int xTo = x + xMove[i];
                int yTo = y + yMove[i];
                coor.add(new info(xTo, yTo, start, cnt+1));
            }
            
        }
        if(ans==-1) System.out.println("KAKTUS");
        else System.out.println(ans);
    }
}

class info{
    int x;
    int y;
    char start;
    int cnt;
    info(int x, int y, char start, int cnt){
        this.x = x;
        this.y = y;
        this.start = start;
        this.cnt = cnt;
    }
}
