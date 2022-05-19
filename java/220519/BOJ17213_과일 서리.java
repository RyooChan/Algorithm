import java.util.*;

public class Main {
    public static void main(String[] args){
    	Scanner sc= new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	
    	int dp[][] = new int[N+1][M+1];
    	
    	for(int i=1; i<=N; i++)
    	{
    		dp[i][i] = 1;
    	}
    	
    	for(int i=1; i<=M; i++)
    	{
    		dp[1][i] = 1;
    	}
    	
    	for(int i=2; i<=N; i++)
    	{
    		for(int j=i+1; j<=M; j++)
    		{
    			for(int k=1; k<j; k++)
    			{
    				dp[i][j] += dp[i-1][k];
    			}
    		}
    	}
    	System.out.println(dp[N][M]);
    }
}
