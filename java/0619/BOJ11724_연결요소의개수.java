/*연결 요소의 개수 성공분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
3 초	512 MB	45277	21517	13996	44.467%
문제
방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

출력
첫째 줄에 연결 요소의 개수를 출력한다.

예제 입력 1 
6 5
1 2
2 5
5 1
3 4
4 6
예제 출력 1 
2
예제 입력 2 
6 8
1 2
2 5
5 1
3 4
4 6
5 4
2 4
2 3
예제 출력 2 
1
*/

// 풀이
import java.util.*;

public class Main {
	
	public static int node[][] = new int[1001][1001];
	public static int N;
	public static int M;
	public static boolean[] check = new boolean[1001];

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0; 
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		for( int i = 0; i < M; i++ ) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			// 각각 그래프 노드를 입력받는다. 양쪽 방향 모두 가능하므로 a,b를 입력받으면 반대도 존재한다고 표시해 준다.
			node[a][b] = node[b][a] = 1;
		}
		
		// 그래프 전체에 대해 진행하는데, 문제를 보면 0부터 시작하는게 아니라 1부터 시작한다. 따라서 전체 크기 1000개에 대해 사용하지 않는 0번 인덱스를 고려하여 1001개로 초기화하고, 문제도 그 이후부터 진행해 준다.
		for(int i=1; i<=N; i++) {
			if( !check[i] ) { // 방문한 적이 없는 장소이면 DFS를 진행한다. 한 번의 방문에서 이어져 있는 모든 개수를 찾아서 방문표시 해 주고, 이게 없어질 때 까지 반복하면 총 연결 요소를 구할 수 있다.
				DFS(i);
				ans++;	// 연결 요소가 있으면 ans++
			}
		}
		
		System.out.println(ans);		// 정답 출력
	}
	
	public static void DFS(int conn) {
		if(check[conn])return;		// 해당 장소를 방문했으면 나가준다. 
		else {		// 방문한 적이 없으면 방문 표시를 해주고, 이곳에서 추가로 방문할 수 있는 장소를 찾는다. 모든 방문 가능한 장소를 고려한다.
			check[conn] = true;
			for( int i=1; i<=N; i++ ) {
				if( node[conn][i] == 1 ) {
					DFS(i);
				}
			}
		}
	}
}
