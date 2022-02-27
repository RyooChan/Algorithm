import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		int x=0;
		int y=0;
		
		long num[][] = new long[N+1][M+1];
		
		int cnt = 0;
		for(int i=1; i<=N; i++){
	        num[i][1] = 1;
		    for(int j=1; j<=M; j++){
		        num[1][j] = 1;
		        cnt++;
		        if(cnt==K){
		            x = i;
		            y = j;
		        }
		    }
		}
		
		if(K!=0){
    		for(int i=x+1; i<N+1; i++) num[i][1] = 0;
    		for(int i=y+1; i<M+1; i++) num[1][i] = 0;
		}
		
		for(int i=2; i<N+1; i++){
		    for(int j=2; j<M+1; j++){
		        if( (K==0) || (i<=x && j<=y) || (i>=x && j>=y)  ){
		            num[i][j] = num[i][j-1] + num[i-1][j];
		        }
		    }
		}
		System.out.println(num[N][M]);
	}
}
