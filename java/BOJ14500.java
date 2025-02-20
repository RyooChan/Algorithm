import java.util.*;

public class Main {
  private static int[][] map;
  private static boolean[][] check;
  private static int[] xMove = {-1, 1, 0, 0};
  private static int[] yMove = {0, 0, -1, 1};
  private static int ans = 0;
  private static int N, M;
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    N = sc.nextInt();
    M = sc.nextInt();
    map = new int[N][M];
    check = new boolean[N][M];
    
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        map[i][j] = sc.nextInt();
      }
    }
    
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        dfs(i, j, 1, 0);
        exceptShape(i, j);
      }
    }
    
    System.out.println(ans);
  }
  
  private static void dfs(int x, int y, int depth, int sum) {
    if(x >= N || y >= M || x < 0 || y < 0 || check[x][y]) return;
    check[x][y] = true;
    sum+=map[x][y];
    
    if(depth == 4) {
      ans = Math.max(ans, sum);
      check[x][y] = false;
      return;
    }
    
    for(int i=0; i<4; i++) {
      int xTo = x + xMove[i];
      int yTo = y + yMove[i];
      dfs(xTo, yTo, depth+1, sum);
    }
    check[x][y] = false;
  }
  
  private static void exceptShape(int x, int y) {
      // ㅗ 모양
      if (x > 0 && y > 0 && y < M - 1) {
          int sum = map[x][y] + map[x - 1][y] + map[x][y - 1] + map[x][y + 1];
          ans = Math.max(ans, sum);
      }
      // ㅜ 모양
      if (x < N - 1 && y > 0 && y < M - 1) {
          int sum = map[x][y] + map[x + 1][y] + map[x][y - 1] + map[x][y + 1];
          ans = Math.max(ans, sum);
      }
      // ㅓ 모양
      if (y > 0 && x > 0 && x < N - 1) {
          int sum = map[x][y] + map[x - 1][y] + map[x + 1][y] + map[x][y - 1];
          ans = Math.max(ans, sum);
      }
      // ㅏ 모양
      if (y < M - 1 && x > 0 && x < N - 1) {
          int sum = map[x][y] + map[x - 1][y] + map[x + 1][y] + map[x][y + 1];
          ans = Math.max(ans, sum);
      }
  }
}
