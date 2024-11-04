import java.util.*;

public class Main
{
  
	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 모듈러 연산
    long MODULAR = 1000000000;
    
    int N = sc.nextInt();
    int K = sc.nextInt();
    
    long val[][] = new long[K+1][N+1];

    // 점화식을 위해 모든 값을 1로 초기화
    for (int i=0; i<K+1; i++) {
      for (int j=0; j<N+1; j++) {
        val[i][j] = 1;
      }
    } 

    // 지금 값을 구하는 점화식을 세워야 한다.
    for (int i=2; i<K+1; i++) {
      for(int j=1; j<N+1; j++) {
        val[i][j] = (val[i-1][j] + val[i][j-1]) % MODULAR;
      }
    }
    
    System.out.println(val[K][N]);
  }
}
