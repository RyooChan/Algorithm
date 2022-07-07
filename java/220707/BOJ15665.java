/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
    private static int N;
    private static int M;
    private static int num[];
    private static StringBuilder sb = new StringBuilder(); 
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	    N = sc.nextInt();
        M = sc.nextInt();
	    num = new int[N];
	    
	    for(int i=0; i<N; i++) num[i] = sc.nextInt();
	    
	    Arrays.sort(num);
	    
        dfs(0,new int[M]);
        System.out.println(sb.toString());
	    
	}
    private static void dfs(int depth, int[] arr) {
        
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        int prev = -1;
        
        for (int i = 0; i < N; i++) {
            if (prev != num[i]) { 
                prev = num[i];
                arr[depth] = prev;
                dfs(depth + 1, arr);
            }
        }
    }
}
