import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Point{
  int x, y;
  public Point(int y, int x) {
     this.x = x;
     this.y = y;
  }
}
public class Main {

    public static Stack<Point> stack = new Stack<>();
    public static int N, K, cnt;
    public static int xMove[] = {0, 0, -1, 1};
    public static int yMove[] = {-1, 1, 0, 0}; 
    public static int[][] map;
    public static boolean[][] check;
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      
      map = new int[N+1][11];
      for (int i=1; i<=N; i++) {
         char[] input = br.readLine().toCharArray();
         for(int j=1; j<=10; j++) {
            map[i][j] = input[j-1] - '0';
         }
      }
      
      while(true) {
         check = new boolean[N+1][11];
         boolean flag = false;
         
         gravity();
         for (int i=N; i>0; i--) {
            for (int j=1; j<=10; j++) {
               if (check[i][j] || map[i][j]==0) continue;
               stack.clear();
               cnt = 0;
               DFS(i, j, map[i][j]);
               
               if (cnt >= K) {
                  flag = true;
                  for (Point p:stack) map[p.y][p.x] = 0;
                  
               }
            }
         } 
         if (!flag) break;
      }
      
      StringBuilder sb = new StringBuilder();
      for (int i=1; i<=N; i++) {
         for (int j=1; j<=10; j++)
            sb.append(map[i][j]);
         sb.append("\n");
      }
      System.out.println(sb.toString());
   }
   
   static void gravity() {
      for (int i= N-1; i>0; i--) {
         for (int j=1; j<=10; j++) {
            if (map[i][j] == 0 || map[i+1][j] != 0) continue;
            
            int z = i+1;
            while(z <= N && map[z][j] == 0) {
               map[z][j] = map[z-1][j];
               map[z-1][j] = 0;
               z++;
            }
         }
      }
   }
	   
   static void DFS (int y, int x, int value) {
      cnt++;
      check[y][x] = true;
      stack.push(new Point(y,x));
      
      for (int i=0; i<4; i++) {
         int xTo = x+xMove[i];
         int yTo = y+yMove[i];
         
         if (yTo<1 || xTo<1 || yTo>N || xTo>10 || check[yTo][xTo]||map[yTo][xTo]!=value) continue;
         
         DFS(yTo, xTo, value);
      }
    }

}
