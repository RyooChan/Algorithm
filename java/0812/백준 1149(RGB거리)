/*
RGB거리 성공
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
0.5 초 (추가 시간 없음)	128 MB	64059	31081	23192	48.461%
문제
RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.

집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

1번 집의 색은 2번 집의 색과 같지 않아야 한다.
N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
입력
첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.

예제 입력 1 
3
26 40 83
49 60 57
13 89 99
예제 출력 1 
96
*/

// 풀이
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int costPer[][] = new int[N][3];  // 각각의 집마다 Red, Green, Blue를 칠하는 데에 필요한 금액을 구한다.
		int costAll[][] = new int[N][3];  // 배열의 첫 번 째 인자까지 칠해진 전체 금액 costAll
		
		for(int i=0; i<N; i++) {    // R G B의 각각 가격을 입력받는다.
			costPer[i][0] = sc.nextInt();
			costPer[i][1] = sc.nextInt();
			costPer[i][2] = sc.nextInt();
		}
		costAll[0][0] = costPer[0][0];  // 맨 윗 집의 색을 칠하는 데에 들어가는 전체 금액은, 당연히 처음 입력받은 금액이다.
		costAll[0][1] = costPer[0][1];
		costAll[0][2] = costPer[0][2];
		
		for(int i=1; i<N; i++) {    // 그리고 두 번째 집부터는 맨 윗 집의 가격에서 추가로 더해질 것이다.
			costAll[i][0] = costPer[i][0] + Math.min(costAll[i-1][1], costAll[i-1][2]); // 맨 윗집을 0번째 인자에 칠하기 시작했으니 그 뒷집은 무조건 그와 달라야 하고, 더 적은 금액을 선택한다. 
			costAll[i][1] = costPer[i][1] + Math.min(costAll[i-1][0], costAll[i-1][2]); // 0, 1, 2 <- R, G, B 세 색에 대해 맨 위로부터 시작해서 전체 금액을 하나씩 구해주면 된다.
			costAll[i][2] = costPer[i][2] + Math.min(costAll[i-1][1], costAll[i-1][0]);
		}
		int ans = Math.min(Math.min(costAll[N-1][0], costAll[N-1][1]), costAll[N-1][2]);    // 그 중 가장 작은 금액이 드는 경우가 ans가 된다.
		
		System.out.println(ans);
		
	}

}
