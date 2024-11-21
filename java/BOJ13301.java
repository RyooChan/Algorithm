/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
    
      int N = sc.nextInt();
      
      int T = Math.max(3, N);
      
      long ans[] = new long[T+1];
      
      ans[1] = 4;
      ans[2] = 6;
      ans[3] = 10;
      
      for(int i=3; i<=T; i++) {
        ans[i] = ans[i-1] + ans[i-2];
      }
      
      System.out.println(ans[N]);
    }
}
