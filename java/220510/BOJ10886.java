import java.util.*;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		int N = sc.nextInt();
	    int aa = 0;
	    
	    for(int i=0; i<N; i++){
	        if(sc.nextInt()==1){
	            aa++;
	        }else{
	            aa--;
	        }
	    }
	    if(aa>0) System.out.println("Junhee is cute!");
	    else System.out.println("Junhee is not cute!");
	}
 
}
