import java.util.*;

public class Main {
    
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
	    PriorityQueue<Integer> height = new PriorityQueue<>(Collections.reverseOrder());
		
		int N = sc.nextInt();
		int centi = sc.nextInt();
		int cnt = sc.nextInt();
		
		for(int i=0; i<N; i++){
		    height.add(sc.nextInt());
		}
		
		for(int i=0; i<cnt; i++){
		    int max = height.poll();
		    if(max<centi){
    		    System.out.println("YES");
    		    System.out.println(i);
    		    return;
		    } 
		    if(max>1) max /= 2;
		    height.add(max);
		}
		
		if(centi <= height.peek()){
		    System.out.println("NO");
		    System.out.println(height.peek());
		}else{
    		    System.out.println("YES");
    		    System.out.println(cnt);
		}
	}
}
