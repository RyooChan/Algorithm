/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
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

        // 최초 시작점은 모두 다르다.
        for(int i=0; i<n+1; i++) parent[i] = i;

        // m번 시행한다.
        for(int i=0; i<m; i++) {
          String input = sc.nextLine();
          
          String spl[] = input.split(" ");
          int checker = Integer.parseInt(spl[0]);
          int x = Integer.parseInt(spl[1]);
          int y = Integer.parseInt(spl[2]);

          // 찾는 과정에서는
          if(checker == 1) {
            if (find(y) == find(x)) System.out.println("YES");  // 둘의 근원이 같으면 같고
            else System.out.println("NO");  // 아니면 NO
          } else {
            union(x, y);  // 둘의 시작점을 맞춰주는 Union 과정
          }
        }
    }
}
