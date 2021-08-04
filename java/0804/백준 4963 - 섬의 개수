/*
섬의 개수 성공출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	33749	16922	12153	49.167%
문제
정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.



한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다. 

두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다. 지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. w와 h는 50보다 작거나 같은 양의 정수이다.

둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.

입력의 마지막 줄에는 0이 두 개 주어진다.

출력
각 테스트 케이스에 대해서, 섬의 개수를 출력한다.

예제 입력 1 
1 1
0
2 2
0 1
1 0
3 2
1 1 1
1 1 1
5 4
1 0 1 0 0
1 0 0 0 0
1 0 1 0 1
1 0 0 1 0
5 4
1 1 1 0 1
1 0 1 0 1
1 0 1 0 1
1 0 1 1 1
5 5
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0
예제 출력 1 
0
1
1
3
1
9
*/

// 풀이
import java.util.*;
 
public class Main {
	public static int w = 1;
	public static int h = 1;  // w, h의 값이 모두 0이면 끝난다. 처음에 값을 받기 위해 1로 세팅해둔다.
	public static int map[][];
	public static boolean check[][];
    static public ArrayList<Integer> ans = new ArrayList<Integer>();    // 정답을 미리 넣어둘 ans
	
	public static int X[] = {-1, -1, -1, 0, 0, 1, 1, 1};  // 대각선까지 이동 가능하다. 이전에 만든 지뢰찾기와 비슷하게 진행된다.
	public static int Y[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		while(w!=0 && h!= 0) {  // 0이 입력되면 끝
			w = sc.nextInt();
			h = sc.nextInt();
			if(w==0 && h==0) break;   // 0이 입력되면 끝
			map = new int[h][w];    // h w로 지도와 체크 만들기
			check = new boolean[h][w];
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int nowAns = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(!check[i][j] && map[i][j]==1) {  // 와본 적이 없는 곳 + 육지이면 새로운 섬이다. 따라서 섬의 개수가 하나 늘어난다.
						nowAns++;   // 섬의 개수를 늘려준다.
						dfs(i, j);  // 해당 섬에서 갈 수 있는 땅을 모두 체크하기 위한 dfs
					}
				}
			}
			ans.add(nowAns);    // 각각 테스트 케이스 마다 nowAns를 구하면 섬의 개수들을 구할 수 있다.
		}
		ans.forEach(answer -> System.out.println(answer));    // 람다식 한번 써봄...이런걸 늘려가야겠다.
	}
	
	public static void dfs(int x, int y) {
		if(x<0 || x>=h || y<0 || y>=w) return;  // map위치를 벗어나면 return
		if(check[x][y] || map[x][y]==0)return;  // 육지가 아니거라, 이미 와본 곳이면 return
		check[x][y] = true;                     // 두 경우가 아니면 육지이고, main문의 섬의 시작점에서 갈 수 있는 곳이다. 즉 이미 존재하는 섬의 땅임.
		
		for(int i=0; i<8; i++) {    // 이 땅에서 갈 수 있는 모든 위치를 탐색한다.
			dfs(x+X[i], y+Y[i]);
		}
	}
}
