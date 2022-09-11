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
        
        int num[][] = new int[10001][4];
        
        num[1][1] = 1;
        
        num[2][1] = 1;
        num[2][2] = 1;
        
        num[3][1] = 1;
        num[3][2] = 1;
        num[3][3] = 1;
        
        for(int i=4; i<10001; i++){
            num[i][1] = num[i-1][1];
            num[i][2] = num[i-2][1] + num[i-2][2];
            num[i][3] = num[i-3][1] + num[i-3][2] + num[i-3][3];
        }
        
        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            int tk = sc.nextInt();
            System.out.println(num[tk][1] + num[tk][2] + num[tk][3]);
        }
        
	}
}
