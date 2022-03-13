import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][][] map = new int[21][21][21];
		
		for(int i = 0; i <= 20; i++)
			for(int j = 0; j <= 20; j++) {
				map[0][i][j] = 1;
				map[i][0][j] = 1;
				map[i][j][0] = 1;
			}
		
		for(int i = 1; i <= 20; i++) 
			for(int j = 1; j <= 20; j++)
				for(int k = 1; k <= 20; k++) {
					if(i < j && j < k) {
						map[i][j][k] = map[i][j][k-1] + map[i][j-1][k-1] - map[i][j-1][k];
						continue;
					}
					map[i][j][k] = map[i-1][j][k] + map[i-1][j-1][k] + map[i-1][j][k-1] - map[i-1][j-1][k-1];					
				}
		String[] input;
		while(true) {
			input = br.readLine().split(" ");
			int a = stoi(input[0]);
			int b = stoi(input[1]);
			int c = stoi(input[2]);
            int ret = 0;
			if(a == -1 && b == -1 && c == -1) {
				System.out.println(sb);
				return;
			}else if(a <= 0 || b <= 0 || c <= 0) ret = 1;
			 else if(a > 20 || b > 20 || c > 20) ret = map[20][20][20];
             else ret = map[a][b][c];
             sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(ret).append("\n");
		}
		
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
