/*
걷기 성공
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	3055	578	486	21.195%
문제
세준이는 학교에서 집으로 가려고 한다. 도시의 크기는 무한대이고, 도시의 세로 도로는 모든 정수 x좌표마다 있고, 가로 도로는 모든 정수 y좌표마다 있다. 세준이는 현재 (0, 0)에 있다. 그리고 (X, Y)에 위치한 집으로 가려고 한다. 세준이가 걸을 수 있는 방법은 두가지 인데, 하나는 도로를 따라서 가로나 세로로 한 블록 움직여서 이번 사거리에서 저 사거리로 움직이는 방법이고, 블록을 대각선으로 가로지르는 방법이 있다.

세준이가 집으로 가는데 걸리는 최소시간을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 집의 위치 X Y와 걸어서 한 블록 가는데 걸리는 시간 W와 대각선으로 한 블록을 가로지르는 시간 S가 주어진다. X와 Y는 1,000,000,000보다 작거나 같은 음이 아닌 정수이고, W와 S는 10,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 세준이가 집에가는데 걸리는 최소시간을 출력한다.

예제 입력 1 
4 2 3 10
예제 출력 1 
18
*/

// 풀이
import java.util.*;
 
public class Main {
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		long X = sc.nextInt();
		long Y = sc.nextInt();    // 얘네는 long으로 해야함
		int W = sc.nextInt();
		int S = sc.nextInt();

		long longer = Math.max(X,  Y);    // 둘 중 긴거, 짧은거를 세준다.
		long shorter = Math.min(X,  Y);
		
		long ans = 0;
		PriorityQueue<Long> routes = new PriorityQueue<>();   // 가장 적은 시간이 걸리는 루트를 고를 것이기에 우선순위 큐 사용
		
		routes.add((long)(longer + shorter)*W);   // 1번루트 -> 그냥 정직하게 직선으로 다니는길
		
		routes.add((longer-shorter)*W + shorter*S); // 2번루트 -> 대각선으로 갈수있는 길은 전부 대각선으로 이동, 나머지는 직선으로 간다.
		
    // 대각선으로 [ \/ ] 이렇게 가는게 [ -- ] 이렇게 가는것보다 짧은 방법일 수 있다.
		if((longer+shorter)%2==0) {   // 대각선으로 쭉 이동해서 전체 이동동선을 갈 수 있으려면 가로세로 합이 짝수여야 한다.
			routes.add(longer * S);   // 그럼 대각선길이만큼 큰 길이를 곱해주면 된다.
		}else { // 홀수라면 한칸은 직선으로 가야한다.
			routes.add((longer-1) * S + W); // 대각선으로 가다가 한칸만 직선으로 간다.
		}
		
		ans = routes.peek();    // 가장 짧은루트 우선순위 큐
		
		System.out.println(ans);

	}
}
