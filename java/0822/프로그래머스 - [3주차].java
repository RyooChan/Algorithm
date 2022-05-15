/*
문제 설명
테이블 위에 놓인 퍼즐 조각을 게임 보드의 빈 공간에 적절히 올려놓으려 합니다. 게임 보드와 테이블은 모두 각 칸이 1x1 크기인 정사각 격자 모양입니다. 이때, 다음 규칙에 따라 테이블 위에 놓인 퍼즐 조각을 게임 보드의 빈칸에 채우면 됩니다.

조각은 한 번에 하나씩 채워 넣습니다.
조각을 회전시킬 수 있습니다.
조각을 뒤집을 수는 없습니다.
게임 보드에 새로 채워 넣은 퍼즐 조각과 인접한 칸이 비어있으면 안 됩니다.
다음은 퍼즐 조각을 채우는 예시입니다.

puzzle_5.png

위 그림에서 왼쪽은 현재 게임 보드의 상태를, 오른쪽은 테이블 위에 놓인 퍼즐 조각들을 나타냅니다. 테이블 위에 놓인 퍼즐 조각들 또한 마찬가지로 [상,하,좌,우]로 인접해 붙어있는 경우는 없으며, 흰 칸은 퍼즐이 놓이지 않은 빈 공간을 나타냅니다. 모든 퍼즐 조각은 격자 칸에 딱 맞게 놓여있으며, 격자 칸을 벗어나거나, 걸쳐 있는 등 잘못 놓인 경우는 없습니다.

이때, 아래 그림과 같이 3,4,5번 조각을 격자 칸에 놓으면 규칙에 어긋나므로 불가능한 경우입니다.

puzzle_6.png

3번 조각을 놓고 4번 조각을 놓기 전에 위쪽으로 인접한 칸에 빈칸이 생깁니다.
5번 조각의 양 옆으로 인접한 칸에 빈칸이 생깁니다.
다음은 규칙에 맞게 최대한 많은 조각을 게임 보드에 채워 넣은 모습입니다.

puzzle_7.png

최대한 많은 조각을 채워 넣으면 총 14칸을 채울 수 있습니다.

현재 게임 보드의 상태 game_board, 테이블 위에 놓인 퍼즐 조각의 상태 table이 매개변수로 주어집니다. 규칙에 맞게 최대한 많은 퍼즐 조각을 채워 넣을 경우, 총 몇 칸을 채울 수 있는지 return 하도록 solution 함수를 완성해주세요.

제한사항
3 ≤ game_board의 행 길이 ≤ 50
game_board의 각 열 길이 = game_board의 행 길이
즉, 게임 보드는 정사각 격자 모양입니다.
game_board의 모든 원소는 0 또는 1입니다.
0은 빈칸, 1은 이미 채워진 칸을 나타냅니다.
퍼즐 조각이 놓일 빈칸은 1 x 1 크기 정사각형이 최소 1개에서 최대 6개까지 연결된 형태로만 주어집니다.
table의 행 길이 = game_board의 행 길이
table의 각 열 길이 = table의 행 길이
즉, 테이블은 game_board와 같은 크기의 정사각 격자 모양입니다.
table의 모든 원소는 0 또는 1입니다.
0은 빈칸, 1은 조각이 놓인 칸을 나타냅니다.
퍼즐 조각은 1 x 1 크기 정사각형이 최소 1개에서 최대 6개까지 연결된 형태로만 주어집니다.
game_board에는 반드시 하나 이상의 빈칸이 있습니다.
table에는 반드시 하나 이상의 블록이 놓여 있습니다.
입출력 예
game_board	table	result
[[1,1,0,0,1,0],[0,0,1,0,1,0],[0,1,1,0,0,1],[1,1,0,1,1,1],[1,0,0,0,1,0],[0,1,1,1,0,0]]	[[1,0,0,1,1,0],[1,0,1,0,1,0],[0,1,1,0,1,1],[0,0,1,0,0,0],[1,1,0,1,1,0],[0,1,0,0,0,0]]	14
[[0,0,0],[1,1,0],[1,1,1]]	[[1,1,1],[1,0,0],[0,0,0]]	0
입출력 예 설명
입출력 예 #1

입력은 다음과 같은 형태이며, 문제의 예시와 같습니다.

puzzle_9.png

입출력 예 #2

블록의 회전은 가능하지만, 뒤집을 수는 없습니다.
*/

// 풀이
import java.util.*;

class Solution {
    public static int Xmove[] = {-1, 1, 0, 0};
    public static int Ymove[] = {0, 0, -1, 1};
    public static Queue<int[]> boardFigure = new LinkedList<>();
    public static Queue<int[]> tableFigure = new LinkedList<>();
    public static Queue<int[]> AfterboardFigure = new LinkedList<>();
    public static Queue<int[]> AftertableFigure = new LinkedList<>();
    public static boolean check[][];
    public static int xArea;
    public static int yArea;
    
    public static int minX;
    public static int minY;
    public static int maxX;
    public static int maxY;
    
    public static int boardCnt;
    public static int tableCnt;
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        xArea = table.length;
        yArea = table.length;
        
        // game_board쪽 도형 만들기
        check = new boolean[xArea][yArea];
        for(int i=0; i<xArea; i++){
            for(int j=0; j<yArea; j++){
                if(!check[i][j] && game_board[i][j]==0){
                    boardCnt = 0;
                    minX = xArea;
                    maxX = 0;
                    minY = yArea;
                    maxY = 0;
                    
                    boardFigureMaker(game_board, i, j);
                    for(int cnt=0; cnt<boardCnt; cnt++){
                        int ans[] = new int[2];
                        ans = boardFigure.poll();
                        ans[0] -= minX;
                        ans[1] -= minY;
                        AfterboardFigure.offer(ans);
                    }
                    AfterboardFigure.offer(new int[]{-1, -1});
                }
            }
        }   
        
        // table쪽 도형 만들기
        check = new boolean[xArea][yArea];
        for(int i=0; i<xArea; i++){
            for(int j=0; j<yArea; j++){
                if(!check[i][j] && table[i][j]==1){
                	tableCnt = 0;
                    minX = xArea;
                    maxX = 0;
                    minY = yArea;
                    maxY = 0;
                    
                    tableFigureMaker(table, i, j);
                    for(int cnt=0; cnt<tableCnt; cnt++){
                        int ans[] = new int[2];
                        ans = tableFigure.poll();
                        ans[0] -= minX;
                        ans[1] -= minY;
                        AftertableFigure.offer(ans);
                    }
                    AftertableFigure.offer(new int[]{-1, -1});
                }
            }
        }   
        
        int nowFigure[][] = new int[11][11];
        int maxX = 0;
        int maxY = 0;
        int minX = 11;
        int minY = 11;
        
        // table도형들을 기준으로 비교할것이다.
        while(!AftertableFigure.isEmpty()){
            int nowTable[] = new int[2];	// X Y축 좌표를 구할 nowTable
            nowTable = AftertableFigure.poll();
            if(nowTable[0]==-1 && nowTable[1]==-1){
                int Xleng = maxX-minX+1;
                int Yleng = maxY-minY+1;
                
                int temp[][] = new int[Xleng][Yleng];

                for(int i=0; i<Xleng; i++){
                    for(int j=0; j<Yleng; j++){
                        temp[i][j] = nowFigure[i][j];
                    }
                }
                for(int num=0; num<4; num++){
                    temp = rotate(temp);
                    int compare = coordinater(temp, temp.length, temp[0].length);
                    if(compare!=0) answer += compare;
                    if(compare!=0) break;
                }
                nowFigure = new int[11][11];
                maxX = 0;
                maxY = 0;
                minX = 11;
                minY = 11;
                continue;
            }
            nowFigure[nowTable[0]][nowTable[1]]++;
            maxX = Math.max(maxX, nowTable[0]);
            minX = Math.min(minX, nowTable[0]);
            maxY = Math.max(maxY, nowTable[1]);
            minY = Math.min(minX, nowTable[1]);
        }
        
        return answer;
    }

    
    public static void boardFigureMaker(int[][] game_board, int x, int y){
        if(x<0 || x>=xArea || y<0 || y>=yArea) return;
        if(check[x][y] || game_board[x][y]==1) return;
        boardCnt++;
        check[x][y] = true;
        maxX = Math.max(maxX, x);
        minX = Math.min(minX, x);
        maxY = Math.max(maxY, y);
        minY = Math.min(minY, y);
        boardFigure.offer(new int[]{x, y});
        
        for(int i=0; i<4; i++){
            boardFigureMaker(game_board, x+Xmove[i], y+Ymove[i]);
        }
    }
    
    public static void tableFigureMaker(int[][] table, int x, int y){
        if(x<0 || x>=xArea || y<0 || y>=yArea) return;
        if(check[x][y] || table[x][y]==0) return;
        tableCnt++;
        check[x][y] = true;

        maxX = Math.max(maxX, x);
        minX = Math.min(minX, x);
        maxY = Math.max(maxY, y);
        minY = Math.min(minY, y);
        tableFigure.offer(new int[]{x, y});
        
        for(int i=0; i<4; i++){
            tableFigureMaker(table, x+Xmove[i], y+Ymove[i]);
        }
    }
    
	public static int[][] rotate(int[][] m) {
		int N = m.length;
		int M = m[0].length;
		// 돌린 크기만큼으로 생성해준다.
		int[][] copyMap = new int[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[j][N - 1 - i] = m[i][j];
			}
		}

		// 새로 돌린 배열로 반환해준다.
		return copyMap;
	}
    
    public static int coordinater(int[][] num, int Xin, int Yin){
        int nowFigureSize = 0;
        int nowFigure[][] = new int[11][11];
        
        int maxX = 0;
        int maxY = 0;
        int minX = 11;
        int minY = 11;
        
        boolean notDiff = true;
        
        Queue<int[]> tempSave = new LinkedList<>();
        int sizeBoard = AfterboardFigure.size();
        
        for(int cnt=0; cnt<sizeBoard; cnt++){
            int nowTable[] = new int[2];
            nowTable = AfterboardFigure.poll();
            tempSave.offer(nowTable);
            
            
            if(nowTable[0]==-1 && nowTable[1]==-1){
                int Xleng = maxX-minX+1;
                int Yleng = maxY-minY+1;

                
                if(Xleng!=Xin || Yleng!=Yin){
                    notDiff = true;
                    while(!tempSave.isEmpty()){
                        AfterboardFigure.offer(tempSave.poll());
                    }
                }else{
                    int temp[][] = new int[Xleng][Yleng];
                    
                    for(int i=0; i<Xleng; i++){
                        for(int j=0; j<Yleng; j++){
                            temp[i][j] = nowFigure[i][j];
                        }
                    }
                    for(int i=0; i<Xleng; i++){
                        for(int j=0; j<Yleng; j++){
                            if(temp[i][j] == num[i][j] && notDiff){
                                if(temp[i][j]==1) nowFigureSize++;
                            }else{
                                nowFigureSize = 0;
                                notDiff = false;
                            }
                        }
                    }
                    if(notDiff){
                        tempSave.clear();
                        return nowFigureSize;
                    } else{
                        notDiff = true;
                        while(!tempSave.isEmpty()){
                            AfterboardFigure.offer(tempSave.poll());
                        }
                    }
                }
                
                nowFigure = new int[11][11];
                maxX = 0;
                maxY = 0;
                minX = 11;
                minY = 11;
                continue;
            }
            nowFigure[nowTable[0]][nowTable[1]]++;
            maxX = Math.max(maxX, nowTable[0]);
            minX = Math.min(minX, nowTable[0]);
            maxY = Math.max(maxY, nowTable[1]);
            minY = Math.min(minY, nowTable[1]);
        }
        return 0;
    }
    
}

// 딱 한줄때문에 4시간을 허비했다.....블로그에 제대로 설명과 함께 포스트할 예정

