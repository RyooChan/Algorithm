// 양 한마리...양 두마리...

import java.io.*;
import java.util.*;

public class Main {
	static int R, C, cnt;
	static int[][] deltas= {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static char[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc=0;tc<TC;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			for (int r=0;r<R;r++) {
				String input = br.readLine();
				map[r] = input.toCharArray();
			}
			cnt = 0; 
            
			for (int r=0;r<R;r++) {
				for (int c=0;c<C;c++) {
					if (map[r][c]=='#') {
						cnt++;
						dfs(r, c);
					}
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int r, int c) {
		map[r][c] = '.';
		for (int d=0;d<4;d++) {
			int nr = r+deltas[d][0];
			int nc = c+deltas[d][1];
			if (isIn(nr,nc) && map[nr][nc]=='#') {
				dfs(nr, nc);
			}
		}
		return;
	}
	
	static boolean isIn(int nr, int nc) {
		return nr>=0 && nr<R && nc>=0 && nc<C;
	}
}
