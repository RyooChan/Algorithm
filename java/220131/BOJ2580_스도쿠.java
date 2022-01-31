import java.util.*;

// 스도쿠
class info{
	int x;
	int y;
	info(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {

	public static int map[][] = new int[9][9];
	public static Queue<info> toFill = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==0) toFill.add(new info(i, j));
			}
		}
		sudoku(0, 0);
	}
	
	public static void sudoku(int row, int col) {
		
		if(row==9) {			// 마지막에 도달했으면(모든 숫자가 채워지면) 정답을 만들어주고 더이상 진행x
			// 출력
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
					sb.append(" ");
				}
				sb.append('\n');
			}
			System.out.print(sb);	
			System.exit(0);
		}

		
		if(col==9) {			// x축의 끝에 도달했으면(col이 9이면) 다음 row를 처음부터 탐색한다.
			sudoku(row+1, 0);
			return;
		}
		
		if(map[row][col]==0) {		// 현재값이 0이면 들어갈 수 있는 모든 경우를 탐색한다.
			for(int i=1; i<10; i++) {
				boolean numChange = fill(row, col, i);		// 지금 0인 위치가 i의 숫자로 변경될 수 있으면
				if(numChange) {			
					map[row][col] = i;		// 그 숫자로 변경한다.
					sudoku(row, col+1);		// 그러면 이제 다음 숫자를 확인한다. 그리고 처음에는 여기서 return을 해버렸는데, 생각해보니까 지금 i가 맞을거라는 보장이 없음.
				}
			}
			map[row][col] = 0;			// i로 변경된 숫자가 정답이 아닐 수 있으니 다른 숫자를 구해주기 위해 다시 0으로 세팅
			return;
		}else {		// 0이 아니면 그냥 다음 process시작
			sudoku(row, col+1);
		}
		
	}
	
	
	// 현재 숫자로 채워넣을 수 있을지?
	public static boolean fill(int row, int col, int num) {
		
		// 열 확인
		for(int i=0; i<9; i++) {
			if( num==map[i][col] ) return false;
		}
		
		// 행 확인
		for(int i=0; i<9; i++) {
			if( num==map[row][i] ) return false;
		}
		
		// 3x3 확인
		int startX = row/3*3;
		int startY = col/3*3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				int xNow = startX+i;
				int yNow = startY+j;
				
				if( num==map[xNow][yNow] ) return false;
				
			}
		}
		
		return true;
	}

}

//두문제 거의 똑같음.
