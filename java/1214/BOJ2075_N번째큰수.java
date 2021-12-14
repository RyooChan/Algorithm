import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int N = sc.nextInt();
        
        for(int i=0; i<N; i++){
            pq.add(sc.nextInt());
        }
        
        for(int i=1; i<N; i++){
            for(int j=0; j<N; j++){
                int now = sc.nextInt();
                if(now > pq.peek()){
                    pq.poll();
                    pq.add(now);
                }
            }
        }
        System.out.println(pq.peek());
    }
}

// 해설 https://hello-backend.tistory.com/90
