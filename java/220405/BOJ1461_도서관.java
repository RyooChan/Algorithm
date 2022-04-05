import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        PriorityQueue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQ = new PriorityQueue<>(Collections.reverseOrder()); 
        
        for(int i=0; i<N; i++){
            int now = sc.nextInt();
            if(now >= 0) plusQ.add(now);
            else minusQ.add(Math.abs(now));
        }
        
        int endPoint = 0;
        
        if(plusQ.isEmpty()) endPoint = minusQ.peek();
        else if(minusQ.isEmpty()) endPoint = plusQ.peek();
        else{
            endPoint = Math.max(minusQ.peek(), plusQ.peek());
        }
        
        int move = 0;
        while(!plusQ.isEmpty()){
            move += plusQ.peek()*2;
            for(int i=0; i<M; i++) plusQ.poll();
        }
        
        while(!minusQ.isEmpty()){
            move += minusQ.peek()*2;
            for(int i=0; i<M; i++) minusQ.poll();
        }
        
        move -= endPoint;
        System.out.println(move);

    }
}

// https://hello-backend.tistory.com/129
