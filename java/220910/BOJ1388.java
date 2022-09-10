/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;

public class Main
{
    private static char map[][];
    private static boolean check[][];
    private static int ans = 0;
    
    private static int N, M;
    
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        map = new char[N][M];
        check = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            String input = sc.next();
            for(int j=0; j<M; j++){
                map[i][j] = input.charAt(j);
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!check[i][j]){
                    DFS(i, j, map[i][j]);
                    ans++;
                }
            }
        }
        System.out.println(ans);
        
	}
	private static void DFS(int x, int y, char now){
	    if(now != map[x][y]) return;
	    
	    check[x][y] = true;
	    
	    if(now == '|'){
	        if(x+1<N)
	        if(!check[x+1][y]){
	            DFS(x+1, y, now);
	        }
	        
	        if(x-1>=0)
	        if(!check[x-1][y]){
	            DFS(x-1, y, now);
	        }
	    }else{
	        if(y-1>=0)
	        if(!check[x][y-1]){
	            DFS(x, y-1, now);
	        }
	        
	        if(y+1<M)
	        if(!check[x][y+1]){
	            DFS(x, y+1, now);
	        }
	    }
	}
}
