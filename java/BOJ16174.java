/******************************************************************************

 Online Java Compiler.
 Code, Compile, Run and Debug java program online.
 Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/
import java.util.*;
import java.io.*;

public class Main
{
    private static int N;
    private static int[][] map;
    private static int[] xMove = {1, 0};
    private static int[] yMove = {0, 1};
    private static String ans = "Hing";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0);
        System.out.println(ans);
    }

    private static void DFS(int x, int y) {
        // 판 밖으로 나가면 체크
        if (x >= N || y >= N) return;
        // 한번 확인했으면 더이상 확인하지 않는다. (원래 check를 해야 하는데 그냥 이렇게 함)
        if (map[x][y] == -2) {
            return;
        }
        // 목적지 도착
        if (map[x][y] == -1) {
            ans = "HaruHaru";
        }
        // 이미 목적지를 도착했으니 더이상은 검색 필요 없다.
        if (ans.equals("HaruHaru")) return;

        // 현재 위치 값 보고
        int now = map[x][y];
        map[x][y] = -2; // 지금 위치는 탐색 완료
        for(int i=0; i<2; i++) {
            // 그래서 현재 위치에서 갈 수 있는 곳을 다 확인
            int xTo = now * xMove[i];
            int yTo = now * yMove[i];

            // 이동이 불가능하다면(이동 후에도 현위치면 볼 필요가 없음)
            if(xTo==0 && yTo==0) return;

            // 다시 DFS
            DFS(x + xTo, y + yTo);
        }
    }
}
