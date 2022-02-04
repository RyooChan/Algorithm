/*
영역 구하기 성공출처
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	22650	12615	10016	56.485%
문제
눈금의 간격이 1인 M×N(M,N≤100)크기의 모눈종이가 있다. 이 모눈종이 위에 눈금에 맞추어 K개의 직사각형을 그릴 때, 이들 K개의 직사각형의 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어진다.

예를 들어 M=5, N=7 인 모눈종이 위에 <그림 1>과 같이 직사각형 3개를 그렸다면, 그 나머지 영역은 <그림 2>와 같이 3개의 분리된 영역으로 나누어지게 된다.



<그림 2>와 같이 분리된 세 영역의 넓이는 각각 1, 7, 13이 된다.

M, N과 K 그리고 K개의 직사각형의 좌표가 주어질 때, K개의 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어지는지, 그리고 분리된 각 영역의 넓이가 얼마인지를 구하여 이를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 M과 N, 그리고 K가 빈칸을 사이에 두고 차례로 주어진다. M, N, K는 모두 100 이하의 자연수이다. 둘째 줄부터 K개의 줄에는 한 줄에 하나씩 직사각형의 왼쪽 아래 꼭짓점의 x, y좌표값과 오른쪽 위 꼭짓점의 x, y좌표값이 빈칸을 사이에 두고 차례로 주어진다. 모눈종이의 왼쪽 아래 꼭짓점의 좌표는 (0,0)이고, 오른쪽 위 꼭짓점의 좌표는(N,M)이다. 입력되는 K개의 직사각형들이 모눈종이 전체를 채우는 경우는 없다.

출력
첫째 줄에 분리되어 나누어지는 영역의 개수를 출력한다. 둘째 줄에는 각 영역의 넓이를 오름차순으로 정렬하여 빈칸을 사이에 두고 출력한다.

예제 입력 1 
5 7 3
0 2 4 4
1 1 2 5
4 0 6 2
예제 출력 1 
3
1 7 13
*/

// 풀이
import java.util.*;
 
public class Main {
	public static int M;  // M N K 각각 입력받기
	public static int N;
	public static int K;
	public static int map[][];  // 지도, 체크용
	public static boolean check[][];
    static public PriorityQueue<Integer> ans = new PriorityQueue<>(); // 답은 낮은 것부터 나오니까 우선순위 큐를 쓰면 됨.
    public static int nowAns;   // 한번의 영역의 크기를 저장할 nowAns
	
	public static int X[] = {-1, 1 , 0, 0};   //dfs용
	public static int Y[] = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int areaCnt = 0;
        
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();

		map = new int[M][N];
		check = new boolean[M][N];      // 각각 입력받고 크기 선언 -> 참고로 박스 크기 잘 설정하면 좌표가 0, 0이 평소랑 달라도 영역 크기는 똑같을 것이다.
		

		for(int i=0; i<K; i++) {
			int leftBottomX = sc.nextInt();   // 왼쪽아래 X Y
			int leftBottomY = sc.nextInt();
			int rightTopX = sc.nextInt();     // 오른쪽위 X Y
			int rightTopY = sc.nextInt();
			
			for(int j=leftBottomY; j<rightTopY; j++) {
				for(int l=leftBottomX; l<rightTopX; l++) {
					map[j][l] = 1;    // 구한 사각형들을 1로 설정함, 그냥 영역들은 0임
				}
			}
		}
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(check[i][j] || map[i][j]==1)continue;    // 한번 탐색 완료된 곳이거나(존재하는 영역에서 찾아짐, 혹은 사각형이면 그냥 continue)
				areaCnt++;    // 새로운 영역이 찾아졌으니 영역 개수 areaCnt를 하나 늘려줌
				nowAns = 0;   // 그 영역 크기는 0으로 세팅
				dfs(i, j);    // dfs시작
				ans.add(nowAns);    // dfs로 구한 영역을 우선순위 큐에 저장
			}
		}
		System.out.println(areaCnt);    // 답 출력
		while(!ans.isEmpty()) System.out.printf("%d ", ans.poll());
	}
	
	public static void dfs(int x, int y) {
		if(x<0 || x>=M || y<0 || y>=N) return;    // map밖이면 return
		if(check[x][y] || map[x][y]==1 )return;   // 이미 찾은 곳이거나 사각형 영역이면 return
		check[x][y] = true;   // 여기는 지금 찾은장소
		nowAns++;              // 사각형 이외 영역이므로 영역 크기 증가
		
		for(int i=0; i<4; i++) {    // 여기서 찾을 수 있는 다른 영역을 찾기 위해 dfs 4방향 
			dfs(x+X[i], y+Y[i]);
		}
	}
}
