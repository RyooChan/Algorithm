import java.io.*;
import java.util.*;

class info{
    int x;
    int y;
    int move;
    info(int x, int y, int move){
        this.x = x;
        this.y = y;
        this.move = move;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        
        int xMove[] = {-1, 1, 0, 0};
        int yMove[] = {0, 0, -1, 1};
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, M;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
    	int map[][] = new int[N][M];
    	int route[][] = new int[N][M];
    	for(int i=0; i<N; i++){
    	    for(int j=0; j<M; j++){
    	        route[i][j] = -1;
    	    }   
    	}
    	boolean check[][] = new boolean[N][M];
    	
    	Queue<info> q = new LinkedList<>();
    	
    	for(int i=0; i<N; i++){
    	    st = new StringTokenizer(br.readLine()); 
    	    for(int j=0; j<M; j++) {
    	        map[i][j] = Integer.parseInt(st.nextToken());
    	        if(map[i][j]==2){
    	            check[i][j] = true;
    	            route[i][j] = 0;
    	            q.add(new info(i, j, 0));
    	        } 
    	    }
    	}
    	
    	while(!q.isEmpty()){
    	    info info = q.remove();
    	    int x = info.x;
    	    int y = info.y;
    	    int move = info.move;
    	    route[x][y] = move;
    	    
    	    for(int i=0; i<4; i++){
    	        int xTo = x + xMove[i];
    	        int yTo = y + yMove[i];
    	        
    	        if(xTo<0 || yTo<0 || xTo>=N || yTo>=M) continue;
    	        if(check[xTo][yTo] || map[xTo][yTo]==0) continue;
    	        check[xTo][yTo] = true;
    	        
    	        q.add(new info(xTo, yTo, (move+1)));
    	    }
    	}
    	
    	for(int i=0; i<N; i++){
    	    for(int j=0; j<M; j++){
    	        if(map[i][j] == 0) route[i][j] = 0;
    	    }   
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<N; i++){
    	    for(int j=0; j<M; j++){
    	        sb.append(route[i][j] + " ");
    	    }sb.append("\n");
    	}
    	System.out.println(sb);
    }
}

// https://hello-backend.tistory.com/147
