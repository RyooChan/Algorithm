/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;

class info implements Comparable<info>{
    int x;
    int y;
    
    info(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(info o) {
        if(this.y == o.y){
            return this.x - o.x;
        }
        return this.y - o.y;
    }
}

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PriorityQueue<info> pq = new PriorityQueue<>();
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) pq.add(new info(sc.nextInt(), sc.nextInt()));
		
		while(!pq.isEmpty()){
		    info info = pq.remove();
		    System.out.println(info.x + " " + info.y);
		}
		
	}
}
