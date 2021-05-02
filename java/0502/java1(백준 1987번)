/*
알파벳 출처다국어분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	256 MB	50119	15794	9643	29.111%
문제
세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다. 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.

말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다. 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.

좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오. 말이 지나는 칸은 좌측 상단의 칸도 포함된다.

입력
첫째 줄에 R과 C가 빈칸을 사이에 두고 주어진다. (1 ≤ R,C ≤ 20) 둘째 줄부터 R개의 줄에 걸쳐서 보드에 적혀 있는 C개의 대문자 알파벳들이 빈칸 없이 주어진다.

출력
첫째 줄에 말이 지날 수 있는 최대의 칸 수를 출력한다.

예제 입력 1 
2 4
CAAB
ADCB
예제 출력 1 
3
*/

// 풀이
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  // 테이블 크기 map 적용
	public static int map[][];
  // A~Z 26개가 있는데, 이를 그냥 0~25로 넣고 check하도록 한다. (check 기본값 false)
	public static boolean check[] = new boolean[26];
  // 말은 위, 아래, 상, 하로 움직일 수 있으니 X축 움직임, Y축 움직임을 추가한다.
  public static int Xmove[] = {-1, 1, 0, 0};
	public static int Ymove[] = {0, 0, -1, 1};
  // 테이블 크기를 입력받는 R, C이다.
	public static int R;
	public static int C;
  // 정답 return용 ans
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
    // 테이블 수 만큼 알파뱃을 테이블의 위치에 배정받는다.
    // char을 사용할 필요 없이 A의 아스키 코드만큼 뺴주면 A~Z는 0~25가 된다.
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j) - 'A';
            }
        }
    // 왼쪽 상단 (0, 0) , 시작 내용 0 - DFS시작
		DFS(0, 0, 0);
    
    
		System.out.println(ans);
	}
	
	public static void DFS(int x, int y, int now) {
		// 이미 지나온 알파뱃이면 DFS를 멈추고 값을 판별함
		if(check[map[x][y]]) {
			ans = Math.max(ans,  now);
			return;
		}
    // 지나오지 않은 길이면 지나왔다고 check에 true로 표시해 준다.
		check[map[x][y]] = true;
    // 상하좌우 판단해서 움직일 수 있는 경우 DFS를 진행하고, now+1로 한칸 이동한 것을 나타내 준다.
		for(int i=0; i<4; i++) {
			if(x+Xmove[i]>=0 && y+Ymove[i]>=0 && x+Xmove[i] < R && y+Ymove[i] < C) {
				DFS(x+Xmove[i], y+Ymove[i], now+1);
			}
		}
    // 가장 중요한 부분인데, 현재 위치 상하좌우에 대한 DFS가 모두 끝났다는 것은, 현재 위치에서 파생되어 더 움직이는 위치가 없다는 것을 의미한다.
    // 그렇다면 이후에 DFS에서 행해질 것은 현재 위치로 오지 않은 경우의 DFS라는 것이다.
    // 따라서 현재 위치의 모든 판단이 끝나면 check를 다시 false로 돌려 다른 DFS할 때에 문제가 발생하지 않도록 한다.
		check[map[x][y]] = false;
		
	}
}
