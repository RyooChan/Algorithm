import java.util.*;

class info implements Comparable<info>{
    int num;
    int absol;
    
    info(int num, int absol){
        this.num = num;
        this.absol = absol;
    }
    
    @Override
    public int compareTo(info o){
        if(this.absol == o.absol){
            return this.num - o.num;
        }else{
            return this.absol - o.absol;
        }
    }
}
public class Main {
    
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
	    PriorityQueue<info> q = new PriorityQueue<>();
		
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++){
		    int input = sc.nextInt();
		    
		    if(input==0){
		        if(q.isEmpty()){
		            System.out.println(0);
		        }else{
		            info info = q.poll();
		            System.out.println(info.num);
		        }
		    }else{
		        q.add(new info(input, Math.abs(input)));
		    }
		}
		
		
	}
}
