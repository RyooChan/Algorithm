import java.util.*;
 
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		int N = sc.nextInt();
		int K = sc.nextInt();	
    	int time = 100002;
    	int same = 0;
    	int spend[] = new int[200001];
    	
		if(N==K){
		    System.out.println(0);
		    System.out.println(1);
		} else{
            Queue<Integer> finder = new LinkedList<>();
		    
    		finder.add(N);
    		spend[N] = 1;
    		
    		while(!finder.isEmpty()) {
		        int step;
    			int nowLoc = finder.poll();
    	        if( time < spend[nowLoc] ) break; 
		        
    			for(int i=0; i<3; i++) {
    				if(i==0) step = nowLoc+1;
    				else if(i==1) step = nowLoc-1;
    				else step = nowLoc*2;
    				
    				if(step<0 || step>100000) continue;
    				
    				if( step==K ){
    				    time = spend[nowLoc];
    				    same++;
    				}
    				
    				if( spend[step]==spend[nowLoc]+1 || spend[step]==0 ) {
    				    finder.add(step);
    				    spend[step] = spend[nowLoc] + 1;
    				}
    			}
    		}
    		System.out.println(time);
    		System.out.println(same);
		}
		
	}
}
