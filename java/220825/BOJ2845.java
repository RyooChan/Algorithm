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
        int M = sc.nextInt();
        int mul = N*M;
        
        for(int i=0; i<5; i++){
            System.out.println(sc.nextInt()-mul);
        }

	}
}
