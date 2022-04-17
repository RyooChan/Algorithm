import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Node{
    int target;
    int cost;
    public Node(int target , int cost){
        this.target = target;
        this.cost = cost;
    }
}

public class Main {
    static Stack<Node> dfsStack = new Stack<>();
    static ArrayList<ArrayList<Node>> nodeArray = new ArrayList<>();
    
    static int [] visited = new int[100001];
    static int [] dist = new int [100001];

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N+1 ; i++){
            nodeArray.add(new ArrayList<>());
        }

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine() , " ");
            int tmp = Integer.parseInt(st.nextToken());
            int x = tmp;
            while(tmp != -1){
                int y = Integer.parseInt(st.nextToken());
                if(y == -1)
                    break;
                int cost = Integer.parseInt(st.nextToken());
                nodeArray.get(x).add(new Node(y , cost));
                nodeArray.get(y).add(new Node(x , cost));
            }
        }

        dfs(1);
        
        int tmp = 0;
        int firstEnd = 0;
        for(int i = 1 ; i < N+1 ; i++){
            if(dist[i] > tmp){
                tmp = dist[i];
                firstEnd = i;
            }
            dist[i] = 0;
            visited[i] = 0;
        }

        dfs(firstEnd);
        System.out.println(Arrays.stream(dist).max().getAsInt());

    }
    public static void dfs(int start){
        dfsStack.add(new Node(start , 0));
        visited[start] = 1;
        while(!dfsStack.empty()){
            Node current = dfsStack.pop();

            for(int i = 0 ; i < nodeArray.get(current.target).size() ; i++){
                Node next = nodeArray.get(current.target).get(i);
                if(visited[next.target] == 0){
                    visited[next.target] = 1;
                    dist[next.target] = current.cost + next.cost;
                    dfsStack.add(new Node(next.target , current.cost + next.cost));
                }
            }
        }
    }
    
}
