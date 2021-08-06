/*
적록색약 성공출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	22139	12826	10087	57.799%
문제
적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.

크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다. 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)

예를 들어, 그림이 아래와 같은 경우에

RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)

그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)

둘째 줄부터 N개 줄에는 그림이 주어진다.

출력
적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.

예제 입력 1 
5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
예제 출력 1 
4 3
*/

// 풀이
import java.util.*;
 
public class Main{
  public static int N;
	public static char color[][];     // RGB각각 입력받을 color
	public static boolean check[][];  // 체크~
	
	public static int X[] = {-1, 1 , 0, 0};
	public static int Y[] = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		N = sc.nextInt();
		color = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String input = sc.next();
			color[i] = input.toCharArray(); // 입력된 ans를 char 배열로 바꾸어 준다.
		}
		
		int ansNormal = 0;    // 보통사람 정답
		check = new boolean[N][N];    // 체크하기 초기화
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!check[i][j]) {
					ansNormal++;    // 정답은 아직 체크하지 않은 곳이면 늘려준다.
					dfs(i, j, color[i][j]); // x, y, 현재 색깔
				}
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(color[i][j]=='G') color[i][j] = 'R';  // 다음 적록색맹은 G와 R을 구분하지 못하므로 둘을 같은 색으로 만들어 준다.
			}
		}
		
		int ansColorweakness = 0;   // 적록색맹 답
		check = new boolean[N][N];   // 체크 초기화
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!check[i][j]) {
					ansColorweakness++;   // 위와 비슷하게 진행한다.
					dfs(i, j, color[i][j]);
				}
			}
		}
		System.out.printf("%d %d", ansNormal, ansColorweakness);
		
	}
	
	public static void dfs(int x, int y, char colorIn) {
		if(x<0 || x>=N || y<0 || y>=N) return;    // 보이는 범위 밖은 return
		if(check[x][y] || color[x][y] != colorIn )return;   // 이미 본 색깔이거나 다른 색이면 return
		check[x][y] = true;
		
		for(int i=0; i<4; i++) {
			dfs(x+X[i], y+Y[i], colorIn);   // 현재 색을 기준으로 주변을 파악한다.
		}
	}
}

// 더 효율적인 방법이 있을 것 같다....
