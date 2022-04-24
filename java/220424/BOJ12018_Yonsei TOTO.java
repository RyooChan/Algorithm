import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int mile = sc.nextInt();
        
        PriorityQueue<Integer> sub = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            PriorityQueue<Integer> now = new PriorityQueue<>(Collections.reverseOrder());
            int human = sc.nextInt();
            int max = sc.nextInt();
            for(int j=0; j<human; j++){
                now.add(sc.nextInt());
            }
            for(int j=0; j<max-1; j++){
                if(!now.isEmpty()) now.remove();
            }
            if(!now.isEmpty()) sub.add(now.peek());
            else sub.add(1);
        }
        int ans = 0;
        while(!sub.isEmpty()){
            if(mile - sub.peek() >= 0){
                mile -= sub.poll();
                ans++;
            }
            else break;
        }
        System.out.println(ans);
    }
} 
