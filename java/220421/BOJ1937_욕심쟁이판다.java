import java.util.*;
import java.io.*;

public class Main {
    public static int map[][];
    public static int move[][];
    public static boolean check[][];
    
    public static int xMove[] = {-1, 1, 0, 0};
    public static int yMove[] = {0, 0, -1, 1};
    
    public static int N;
    public static int ans = 1;
    
	public static void main(String[] args) throws IOException {
	    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		move = new int[N][N];
		check = new boolean[N][N];
		
		for(int i=0; i<N; i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0; j<N; j++){
		        map[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		for(int i=0; i<N; i++){
		    for(int j=0; j<N; j++){
		        if(check[i][j]) continue;
		        ans = Math.max(ans, DFS(i, j));
		    }
		}
		
// 		for(int i=0; i<N; i++){
// 		    for(int j=0; j<N; j++){
// 		        System.out.printf("%d ", move[i][j]);
// 		    }
// 	    	System.out.println();
// 		}
		System.out.println(ans);
		
    }
    public static int DFS(int x, int y){
        check[x][y] = true;
        int moves = 1;
        
        for(int i=0; i<4; i++){
            int xTo = x + xMove[i];
            int yTo = y + yMove[i];
            int moveTo = 1;
            if(xTo<0 || yTo<0 || xTo>=N || yTo>=N) continue;
            if(map[xTo][yTo] <= map[x][y]) continue;
            if(check[xTo][yTo]){
                moves = Math.max(moves, move[xTo][yTo]+1);
            }else{
                moveTo = DFS(xTo, yTo)+1;
                moves = Math.max(moves, moveTo);
            }
        }
        move[x][y] = moves;
        
        return moves;
    }
}
