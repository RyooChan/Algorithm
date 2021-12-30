import java.util.*;

class stover implements Comparable<stover>{
    int end;
    int cost;
    stover(int end, int cost){
        this.end = end;
        this.cost = cost;
    }
    @Override
    public int compareTo(stover o) {
        return this.cost - o.cost;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        ArrayList<ArrayList<stover>> cow = new ArrayList<>();
        for(int i=0; i<N+1; i++) cow.add(new ArrayList<>());
        
        for(int i=0; i<M; i++){
            int route1 = sc.nextInt();
            int route2 = sc.nextInt();
            int cost = sc.nextInt();
            cow.get(route1).add(new stover(route2, cost));
            cow.get(route2).add(new stover(route1, cost));    // 양방향 다익스트라
        }
        
        int need[] = new int[N+1];
        boolean check[] = new boolean[N+1];
        
        Arrays.fill(need, Integer.MAX_VALUE);
        
        PriorityQueue<stover> move = new PriorityQueue<>();
        move.add(new stover(1, 0));
        need[1] = 0;
        
        while(!move.isEmpty()){
            stover startSpot = move.poll();
            int startLoc = startSpot.end;
            if(check[startLoc]) continue;
            for(stover goSpot : cow.get(startLoc)){
                int destination = goSpot.end;
                int cost = goSpot.cost;
                if(check[destination]) continue;
                if(need[destination] > need[startLoc] + cost){
                    need[destination] = need[startLoc] + cost;
                    move.add( new stover(destination, need[destination]));
                }
            }
        }
        System.out.println(need[N]);
    }
}
