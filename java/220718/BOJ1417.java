import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int mine = sc.nextInt();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<N-1; i++)pq.add(sc.nextInt());
        
        int ans = 0;
        if(!pq.isEmpty())
        while(mine <= pq.peek()){
            ans++;
            int max = pq.poll();
            max--;
            mine++;
            pq.add(max);
        }
    
        System.out.println(ans);
    }
}
