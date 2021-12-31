import java.util.*;

class info implements Comparable<info>{
    int end;
    int weight;
    
    info(int end, int weight){
        this.end = end;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(info o) {
        return this.weight - o.weight;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();
        int startPoint = sc.nextInt();
        
        ArrayList<ArrayList<info>> nodes = new ArrayList<>();
        for(int i=0; i<V+1; i++) nodes.add(new ArrayList<>());
        
        int cost[] = new int[V+1];
        boolean check[] = new boolean[V+1];
        
        for(int i=0; i<E; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            // System.out.println(start);
            nodes.get(start).add(new info(end, weight));
        }
        
        for(int i=0; i<V+1; i++) cost[i] = Integer.MAX_VALUE;
        PriorityQueue<info> finder = new PriorityQueue<>();
        cost[startPoint] = 0;
        finder.add(new info(startPoint, 0));
        
        while(!finder.isEmpty()){
            info startCheck = finder.poll();
            int start = startCheck.end;
            
            if(check[start]) continue;
            check[start] = true;                
            // System.out.println(start + "!");
            
            for(info destination : nodes.get(start)){
                int togo = destination.end;
                int weight = destination.weight;
                
                // System.out.println(togo + "--" + cost[start]);
                if(check[togo]) continue;
                // System.out.println(togo + "--" + cost[start]);
                if(cost[togo] > weight + cost[start]){
                    cost[togo] =  weight + cost[start];
                    finder.add(new info(togo, cost[togo]));
                }
                
            }
            
        }
        
        for(int i=1; i<=V; i++){
            if(check[i]) System.out.println(cost[i]);
            else System.out.println("INF");
        }
        
    }
}

