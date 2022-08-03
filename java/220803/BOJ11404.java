import java.io.*;
import java.util.*;

public class Main {
    static int[] cityCost = new int[101];
    static class Route{
        int target;
        int cost;
        public Route( int target, int cost) {
            this.target = target;
            this.cost = cost;
        }
    }
    static PriorityQueue<Route> pq = new PriorityQueue<>(new Comparator<Route>() {
        @Override
        public int compare(Route o1, Route o2) {
            return o1.cost-o2.cost;
        }
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<ArrayList<Route>> nodes = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n+1;i++){
            nodes.add(new ArrayList<>());
        }
        int m = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < m ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            nodes.get(start).add(new Route(target, cost));
        }
        for(int z = 1 ; z < n+1; z++){
            for(int i = 0 ; i < nodes.get(z).size() ; i++){
                pq.add(nodes.get(z).get(i));
            }
            while(!pq.isEmpty()){
                Route next = pq.poll();
                int start = next.target;
                int cost = next.cost;
                if(cityCost[start] != 0){
                    continue;
                }
                cityCost[start] = cost;
                for(int i = 0 ; i < nodes.get(start).size() ; i++){
                    int nextCost = cost + nodes.get(start).get(i).cost;
                    int target = nodes.get(start).get(i).target;
                    if(cityCost[target] == 0){
                        pq.add(new Route(target , nextCost));
                    }
                }
            }
            cityCost[z] = 0;
            for(int i = 1 ; i < n+1 ; i++){
                bw.write(cityCost[i] + " ");
                cityCost[i] = 0;
            }
            bw.write("\n");
        }
        bw.close();
    }
}
