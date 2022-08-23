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
	    
	    int H = sc.nextInt();
	    int M = sc.nextInt();
	    int S = sc.nextInt();
	    
	    int input = sc.nextInt();
	    
	    S += input;
	    M += S/60;
	    S %= 60;
	    
	    H += M / 60;
	    M %= 60;
	    
	    H %= 24;
	    
	    System.out.printf("%d %d %d", H, M, S);
	}
}
