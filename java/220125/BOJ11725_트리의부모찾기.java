import java.util.*;

public class Main{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
      
        int N = sc.nextInt();
        ArrayList< ArrayList<Integer> > tree = new ArrayList<>();
        
      // tree들이 들어갈 노드 초기화 0 ~ N+1까지
        for(int i=0; i<N+1; i++){
            tree.add(new ArrayList<Integer>());
        }
        
      // 값을 받아서 각 노드 연결시키기
        for(int i=0; i<N-1; i++){
            int one = sc.nextInt();
            int two = sc.nextInt();
            tree.get(one).add(two);
            tree.get(two).add(one);
        }
        
      // 부모노드 저장될 ans
        int ans[] = new int[N+1];
      // 방문확인 check
        boolean check[] = new boolean[N+1];
        Queue<Integer> finder = new LinkedList<>(); // BFS용 finder
        finder.add(1);  // root는 1이다.
        
        while(!finder.isEmpty()){
            int now = finder.poll();  // 현재 노드를 기준으로 자식을 확인할거다
            ArrayList<Integer> sons = tree.get(now);  // 현재 노드의 자식들
            
            for(int son : sons){    // 각각의 자식에 대해
                if(check[son]) continue;  // 방문했으면 안함(바로 자신의 부모를 찾는거라 루트노드부터 구해지는 배열이 바로 부모임.
                check[son] = true;  // 방문check
                ans[son] = now;   // 그 바로 부모 저장하기
                
                finder.add(son);    // 현재가 부모가 되는 노드 찾기
            }
            
        }
        for(int i=2; i<N+1; i++){
            System.out.println(ans[i]);   // 2부터 찾는거죠
        }
      
    }
}
