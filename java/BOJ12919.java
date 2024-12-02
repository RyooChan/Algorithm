import java.util.*;

public class Main
{
  private static String S;
  private static int ans = 0;
  
	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    S = sc.next();
    String T = sc.next();
    
    StringBuilder before = new StringBuilder();
    before.append(T);
    
    DFS(before);
    System.out.println(ans);
  }
  
  private static void DFS(StringBuilder before) {
    if (ans == 1) return;
    
    if (before.length() == S.length()) {
      if (before.toString().equals(S)) {
        ans = 1;
      }
      return;
    }
    
    if (before.toString().endsWith("A")) {
      StringBuilder now = new StringBuilder(before);
      now.deleteCharAt(now.length() - 1);
      DFS(now);
    }
    
    if (before.toString().startsWith("B")) {
      StringBuilder now = new StringBuilder(before);
      now.reverse();
      now.deleteCharAt(now.length() - 1);
      DFS(now);
    }
    
  }
}
