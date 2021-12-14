// 별찍기


// 풀이
import java.util.*;

public class Main {	
	
	public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int star = sc.nextInt();
        
        for(int i=0; i<star; i++){
            for(int j=0; j<=i; j++)
                System.out.printf("*");
            System.out.println("");
        }
		        
	}
	
	
}
