import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static char map[][];
    public static int xMove[] = {1, 0};
    public static int yMove[] = {0, 1};
    
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;
    
    public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(bf.readLine());
        map = new char[N][N];
        
        for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0; j<N; j++){
				map[i][j] = st.nextToken().charAt(0);
            }
        }
        
        DFS(0, 0, 0, '+');
        System.out.println(max);
        System.out.println(min);

    }
    public static void DFS(int x, int y, int nowNum, char oper){
        if(x<0 || y<0 || x>=N || y>=N) return;
        
        if(x==N-1 && y==N-1){
            int now = map[x][y] - '0';
            nowNum = cal(nowNum, now, oper);
            min = Math.min(min, nowNum);
            max = Math.max(max, nowNum);
            return;
        }
        
        if((x+y)%2==0){
            int now = map[x][y] - '0';
            nowNum = cal(nowNum, now, oper);
        }else{
            oper = map[x][y];
        }
        
        for(int i=0; i<2; i++){
            int xTo = x+xMove[i];
            int yTo = y+yMove[i];
            DFS(xTo, yTo, nowNum, oper);
        }
    }
    
    public static int cal(int A, int B, char oper){
        switch(oper){
            case '+' : return A+B;
            case '-' : return A-B;
            case '*' : return A*B;
            default : return 0;
        }
    }
}
