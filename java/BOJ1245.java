/******************************************************************************

 Online Java Compiler.
 Code, Compile, Run and Debug java program online.
 Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/
import java.util.*;

public class Main
{
    private static int map[][];
    private static int N, M;
    private static boolean check[][];

    private static int xMove[] = {1, 1, 1, 0, 0, -1, -1, -1};
    private static int yMove[] = {1, -1, 0, 1, -1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        map = new int[N][M];
        check = new boolean[N][M];

        for (int i=0; i<N; i++) {
            String input = sc.nextLine();
            String[] inputStr = input.split(" ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(inputStr[j]);
            }
        }

        int ans = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!check[i][j]) {
                    if(DFS(i, j)) ans++; // 산봉우리가 맞다면 정답 취급해준다.
                }
            }
        }

        System.out.println(ans);
    }

    private static boolean DFS(int x, int y) {
        check[x][y] = true;  // 해당 위치는 확인했다고 표시
        int now = map[x][y]; // 현재 위치의 높이
        boolean isPeak = true; // 아무 문제 없으면 산봉우리
        
        // 여기서 확인한다.
        for(int i=0; i<xMove.length; i++) {
            int xTo = x + xMove[i];
            int yTo = y + yMove[i];

            if (xTo<0 || yTo<0 || xTo>=N || yTo>=M) continue; // 맵 안에 위치하고

            if (map[xTo][yTo] > now) isPeak = false; // 인접 지형이 하나라도 높은 칸이면 산봉우리가 아니다.
            else if (map[xTo][yTo] == now && !check[xTo][yTo]) { // 인접 지형이 같은 높이면 얘도 확인해야한다. 한번 봤으면 더 안봄(계속 서로 볼수 있으니)
                if (!DFS(xTo, yTo)) { // 그래서 인접한 같은 높이도 산봉우리가 아니면 이것도 산봉우리가 아니다.
                    isPeak = false;
                }
            }
        }

        return isPeak;  // 산봉우리인지 아닌지 반환
    }
}
