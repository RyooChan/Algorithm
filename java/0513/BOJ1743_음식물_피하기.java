/*
음식물 피하기 성공출처다국어분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	5722	2637	2204	46.814%
문제
코레스코 콘도미니엄 8층은 학생들이 3끼의 식사를 해결하는 공간이다. 그러나 몇몇 비양심적인 학생들의 만행으로 음식물이 통로 중간 중간에 떨어져 있다. 이러한 음식물들은 근처에 있는 것끼리 뭉치게 돼서 큰 음식물 쓰레기가 된다. 

이 문제를 출제한 선생님은 개인적으로 이러한 음식물을 실내화에 묻히는 것을 정말 진정으로 싫어한다. 참고로 우리가 구해야 할 답은 이 문제를 낸 조교를 맞추는 것이 아니다. 

통로에 떨어진 음식물을 피해가기란 쉬운 일이 아니다. 따라서 선생님은 떨어진 음식물 중에 제일 큰 음식물만은 피해 가려고 한다. 

선생님을 도와 제일 큰 음식물의 크기를 구해서 “10ra"를 외치지 않게 도와주자.

입력
첫째 줄에 통로의 세로 길이 N(1 ≤ N ≤ 100)과 가로 길이 M(1 ≤ M ≤ 100) 그리고 음식물 쓰레기의 개수 K(1 ≤ K ≤ 10,000)이 주어진다.  그리고 다음 K개의 줄에 음식물이 떨어진 좌표 (r, c)가 주어진다.

좌표 (r, c)의 r은 위에서부터, c는 왼쪽에서부터가 기준이다.

출력
첫째 줄에 음식물 중 가장 큰 음식물의 크기를 출력하라.

예제 입력 1 
3 4 5
3 2
2 2
3 1
2 3
1 1
예제 출력 1 
4
*/

// 풀이
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, ky, kx, cnt, max = Integer.MIN_VALUE;
	static int[][] food, visited;
	static Queue<int[]> que = new LinkedList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		food = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < K; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			ky = Integer.parseInt(st2.nextToken());
			kx = Integer.parseInt(st2.nextToken());
			food[ky-1][kx-1] = 1;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(food[i][j] == 1 && visited[i][j] == 0) {
					bfs(i,j);
					max = (Math.max(max, cnt)==max) ? max : cnt;
				}
			}
		}
		System.out.println(max);
	} 
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	private static void bfs(int y, int x) {
		cnt = 1;
		que.clear();
		que.add(new int[] {y,x});
		visited[y][x] = 1;
		while(!que.isEmpty()) {
			int[] curr = que.poll();
			int cy = curr[0];
			int cx = curr[1];
			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				if(!check(ny,nx)) {continue;}
				if(food[ny][nx] == 1 && visited[ny][nx] == 0) {
					visited[ny][nx] = 1;
					cnt++;
					que.add(new int[] {ny,nx});
				}
			}
		}
	}
	private static boolean check(int ny, int nx) {
		if(ny<0 || ny>=N || nx<0 || nx>=M) {return false;}
		return true;
	}
} 
