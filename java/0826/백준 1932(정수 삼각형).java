/*
정수 삼각형 성공출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	49976	27433	20551	58.741%
문제
        7
      3   8
    8   1   0
  2   7   4   4
4   5   2   6   5
위 그림은 크기가 5인 정수 삼각형의 한 모습이다.

맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라. 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.

삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.

입력
첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고, 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어진다.

출력
첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력한다.

예제 입력 1 
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
예제 출력 1 
30
*/

// 풀이
import java.util.*;
 
public class Main {
	public static String ans = "";
	public static int N;
	public static int num[][];  // 삼각형 입력받기
	public static int sum[][];  // 삼각형 수들의 합
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();   // 총 삼각형 개수
		num = new int[N][N];    // 그만큼 초기화 해주고
		sum = new int[N][N];
		
		for(int i=0; i<N; i++) {  
			for(int j=0; j<=i; j++) {
				num[i][j] = sc.nextInt();
			}
		}
		
		sum[0][0] = num[0][0];  // 맨 위의 합은 당연히 삼각형 맨위크기이다.

		for(int i=1; i<N; i++)
			sum[i][0] = num[i][0] + sum[i-1][0];  // 맨 왼쪽 값들은 전체가 다 왼쪽으로 이동해야 한다. 그럼 당연히 이전값에 현재 삼각형 값을 더한 값
		
		for(int i=1; i<N; i++) { 
			for(int j=1; j<=i; j++) {
				sum[i][j] = num[i][j] + Math.max(sum[i-1][j-1], sum[i-1][j]); // 나머지 최대값은 현재값 기준 위에서 오른쪽 왼쪽중 큰값을 구하면 될것이다.
			}
		}
		
		int ans = 0;
		for(int i=0; i<N; i++)
			ans = Math.max(ans, sum[N-1][i]);   // 답은 가장 큰거임.
		
		System.out.println(ans);
	}
}
