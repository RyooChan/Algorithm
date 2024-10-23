import java.util.*;

public class Main
{
  private static int[] parent;
  
  private static int find(int x) {
    if (x == parent[x]) {
      return x;
    }
    
    return parent[x] = find(parent[x]);
  }
  
  private static void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    
    if (rootX != rootY) {
      parent[rootY] = rootX;
    }
  }
  
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        parent = new int[n + 1];
        
        // 최초 초기화
        for(int i=0; i<n+1; i++) parent[i] = i;
        
        for(int i=1; i<n+1; i++) {
          String input = sc.nextLine();
          String spl[] = input.split(" ");
          
          for(int j=1; j<spl.length; j++) {
            int line = Integer.parseInt(spl[j-1]);
            if(line == 1) {
              union(i, j);    // 각 도시를 연결해준다. 1이면 연결됨
            }
          }
        }
        
        // 연결되는 도시를 찾기 위해 입력
        String input2 = sc.nextLine();
        String spl2[] = input2.split(" ");
        
        boolean check = true;
        // 모든 도시가 연결되었는지를 찾기 위해서는 서로 인접한 것이 다 같다면 모두가 연결된 것이다.
        for(int i=1; i<spl2.length; i++) {
          if(!check) break;
          if(find(Integer.parseInt(spl2[i-1])) != find(Integer.parseInt(spl2[i]))) check = false;
        }
        
        if(check) System.out.println("YES");
        else System.out.println("NO");
    }
}
