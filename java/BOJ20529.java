import java.util.*;

public class Main
{

	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int T = sc.nextInt();
    
    while(T-->0) {
      int N = sc.nextInt();
      
      ArrayList<String> mbtiList = new ArrayList<>();
      
      for(int i=0; i<N; i++) {
        String mbti = sc.next();
        mbtiList.add(mbti);
      }
    
      int ans = Integer.MAX_VALUE;
      for(int i=0; i<mbtiList.size(); i++) {
        for(int j=i+1; j<mbtiList.size(); j++) {
          for(int k=j+1; k<mbtiList.size();k++) {
            String first = mbtiList.get(i);
            String second = mbtiList.get(j);
            String third = mbtiList.get(k);
            
            int cnt = distance(first, second) + distance(second, third) + distance(first, third);
            ans = Math.min(ans, cnt);
          }
        }
      }
      System.out.println(ans);
    }
	}
	
	private static int distance(String a, String b) {
	  int cnt = 0;
	  for(int i=0; i<4; i++) {
	    if (a.charAt(i) != b.charAt(i)) cnt++; 
	  }
	  return cnt;
	}
}
