/*
공유기 설치 성공
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	23413	9194	6615	40.718%
문제
도현이의 집 N개가 수직선 위에 있다. 각각의 집의 좌표는 x1, ..., xN이고, 집 여러개가 같은 좌표를 가지는 일은 없다.

도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 한다. 최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에, 한 집에는 공유기를 하나만 설치할 수 있고, 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.

C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.

입력
첫째 줄에 집의 개수 N (2 ≤ N ≤ 200,000)과 공유기의 개수 C (2 ≤ C ≤ N)이 하나 이상의 빈 칸을 사이에 두고 주어진다. 둘째 줄부터 N개의 줄에는 집의 좌표를 나타내는 xi (0 ≤ xi ≤ 1,000,000,000)가 한 줄에 하나씩 주어진다.

출력
첫째 줄에 가장 인접한 두 공유기 사이의 최대 거리를 출력한다.

예제 입력 1 
5 3
1
2
8
4
9
예제 출력 1 
3
*/

// 풀이
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int C = sc.nextInt();
		int house[] = new int[N+1];
		int ans = 0;
		
		for(int i=1; i<=N; i++) {
			house[i] = sc.nextInt();
		}
		Arrays.sort(house);
		
		int start = 1;
		int end = house[N-1] - house[0];
		int comp;
		
		while(start <= end) {
			int middle = (start + end) / 2;
			int first = house[1];
			int cnt = 1;
			for(int i=1; i<=N; i++) {
				comp = house[i] - first;
				if(comp >= middle) {
					cnt++;
					first = house[i];
				}
			}
			if(cnt >= C) {
				ans = middle;
				start = middle+1;
			}else {
				end = middle - 1;
			}
			
		}
		System.out.println(ans);
		
	}
	
}
