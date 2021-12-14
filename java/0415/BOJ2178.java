/*
미로 탐색 성공분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	192 MB	88740	34998	22317	38.164%
문제
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

예제 입력 1 
4 6
101111
101010
101011
111011
예제 출력 1 
15
예제 입력 2 
4 6
110110
110110
111111
111101
예제 출력 2 
9
예제 입력 3 
2 25
1011101110111011101110111
1110111011101110111011101
예제 출력 3 
38
예제 입력 4 
7 7
1011111
1110001
1000001
1000001
1000001
1000001
1111111
예제 출력 4 
13
*/

// 풀이
import java.util.*;

public class Main {
    // 위 아래 양옆 확인용 XY
	static int X[] = {-1, 1, 0, 0};
	static int Y[] = {0, 0, -1, 1};
	
	public static void main(String[] args) {
        // 양옆 - X, 위아래 - Y를 넣고 확인하기 위한 queue 두 개 선언 확인하기 위한 queue 두 개 선언
		Queue<Integer>ruteX = new LinkedList<>();
		Queue<Integer>ruteY = new LinkedList<>();

        // 입력
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
        // 모든 미로를 다 돌아야 나오는 수, 아무리 길이 많아도 A*B가 최대 길이일것이다.
		int ans = A * B;
        // 미로 길 있으면 1 없으면 0
		int maze[][] = new int [A][B];
        // 길을 갔는지 확인하기 위한 check
		boolean check[][] = new boolean[A][B];
		
		for(int i=0; i<A; i++) {
			String input = sc.next();
			for(int j=0; j<B; j++) {
				maze[i][j] = input.charAt(j) - 48;
			}
		}
		
        // 시작점의 위치 넣기
		ruteX.add(0);
		ruteY.add(0);
		
        // 다 빠질 때 까지 시행한다.
		while(!ruteX.isEmpty() && !ruteY.isEmpty()) {
            // 현위치를 poll해서 넣어준다.
			int nowX = ruteX.poll();
			int nowY = ruteY.poll();
			
            // 현재 미로가 길이 있고 와보지 않은 길일 때
			if(maze[nowX][nowY]!=0 && !check[nowX][nowY]) {
                // 위아래 양옆 봐서 그 길이 존재하는 길이고, 다음으로 갈 길이 존재할 때
				for(int i=0; i<4; i++) {
					if(nowX+X[i]>=0 && nowX+X[i] < A && nowY+Y[i]>=0 && nowY+Y[i]<B && maze[nowX+X[i]][nowY+Y[i]]!=0) {
						// 마지막 길까지 이동하는데, 다음 길은 현재 길보다 1칸 더 이동하는 것이다.
                        maze[nowX+X[i]][nowY+Y[i]] = maze[nowX][nowY]+1;
                        // 왔던 길은 true
						check[nowX][nowY] = true;
                        // 그래서 다음 길에서 이 while문의 process를 진행하도록 더해준다.
						ruteX.add(nowX+X[i]);
						ruteY.add(nowY+Y[i]);
					}
				}
			}
			
            // 마지막까지 오는 경우가 여러개일 때, 최소를 구하기 위한 조건문
			if(nowX==A-1 && nowY==B-1 && ans>maze[nowX][nowY]) {
				ans = maze[A-1][B-1];
			}
				
			
		}
		
		System.out.println(ans);
	}
 
}
