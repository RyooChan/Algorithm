/*
가장 긴 증가하는 부분 수열 성공
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	80522	31229	20536	36.994%
문제
수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.

예제 입력 1 
6
10 20 10 30 20 50
예제 출력 1 
4
*/

// 풀이
import java.util.*;
 
public class Main {
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num[] = new int[N];   // 숫자
		int leng[] = new int[N];  // 그곳까지 도달하는 가장 긴 길이
		
		for(int i=0; i<N; i++)
			num[i] = sc.nextInt();
		
		leng[0] = 1;  // 처음 길이는 당연히 1이다.
		
		for(int i=1; i<N; i++) {
			for(int j=i-1; j>=0; j--) { // 현재 숫자를 기준으로 이전 숫자들을 탐색하면서
				if(num[i] > num[j]) { // 현재가 이전보다 증가하는 숫자인 경우
					leng[i] = Math.max(leng[i], leng[j]);   // 가장 긴 것을 구해준다.
				}
			}
			leng[i]++;  // 그리고 현재 길이는 1을 더하면 된다.
		}
		int ans = 0;
		for(int i=0; i<N; i++)
			ans = Math.max(ans, leng[i]);   // 최대값이 정답
		
		System.out.println(ans);
	}
}
