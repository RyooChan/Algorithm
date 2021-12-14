/*
숫자의 개수 성공출처분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	89012	53460	44694	60.250%
문제
세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.

예를 들어 A = 150, B = 266, C = 427 이라면 A × B × C = 150 × 266 × 427 = 17037300 이 되고, 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.

입력
첫째 줄에 A, 둘째 줄에 B, 셋째 줄에 C가 주어진다. A, B, C는 모두 100보다 크거나 같고, 1,000보다 작은 자연수이다.

출력
첫째 줄에는 A × B × C의 결과에 0 이 몇 번 쓰였는지 출력한다. 마찬가지로 둘째 줄부터 열 번째 줄까지 A × B × C의 결과에 1부터 9까지의 숫자가 각각 몇 번 쓰였는지 차례로 한 줄에 하나씩 출력한다.

예제 입력 1 
150
266
427
예제 출력 1 
3
1
0
2
0
0
0
2
0
0
*/

// 풀이
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        String input = (A * B * C) + "";
        for(int i=0; i<10; i++){
            char comp = (char)(i +'0');
            int ans = 0;
            for(int j=0; j<input.length(); j++){
                if(input.charAt(j) == comp) ans++;
            }
            System.out.println(ans);
        }
        
        
	}

}
