import java.util.*;

class info implements Comparable<info>{
    int cost;
    int weight;
    
    info(int cost, int weight){
        this.cost = cost;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(info o) {
        if(this.cost == o.cost) return o.weight - this.weight;
        return this.cost - o.cost;
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long M = sc.nextInt();
        
        PriorityQueue<info> pq = new PriorityQueue<>();
        
        for(int i=0; i<N; i++){
            int weight = sc.nextInt();
            int cost = sc.nextInt();
            pq.add(new info(cost, weight));
        }
        
        boolean isTrue = false;
        int wholeCost = 0;
        long wholeWeight = 0;
        
        int saveBeforeCost = -1;
        int sameCost = 0;
        
        int answer = Integer.MAX_VALUE;
        
        while(!pq.isEmpty()){
            info info = pq.poll();
            int weight = info.weight;
            int cost = info.cost;
            if(saveBeforeCost != cost){
                saveBeforeCost = cost;
                sameCost = 0;
            }else{
                sameCost += cost;
            }
            
            wholeWeight += weight;
            wholeCost = cost;
            
            if(wholeWeight >= M){
                isTrue = true;
                answer = Math.min(answer, wholeCost + sameCost);
            } 
        }
        if(isTrue) {
            System.out.println(answer);
        }
        else System.out.println(-1);

    }
}

// https://hello-backend.tistory.com/143
