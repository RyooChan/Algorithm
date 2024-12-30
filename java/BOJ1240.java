/******************************************************************************

 Online Java Compiler.
 Code, Compile, Run and Debug java program online.
 Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/
import java.util.*;

public class Main {
    private static ArrayList<Info>[] nodes;
    private static boolean check[];
    private static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        nodes = new ArrayList[N+1];
        for(int i=1; i<=N; i++) nodes[i] = new ArrayList<>();

        for(int i=1; i<N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            // a가 기준으로 b 로 가는 거리
            Info info = new Info(b, c);
            nodes[a].add(info);

            // b가 기준으로 a 로 가는 거리
            info = new Info(a, c);
            nodes[b].add(info);
        }

        for(int i=0; i<M; i++) {
            // 매번 초기화해주면서 확인한다.
            ans = Integer.MAX_VALUE;
            check = new boolean[N+1];
            int a = sc.nextInt();
            int b = sc.nextInt();
            DFS(a, b, 0);
            System.out.println(ans);
        }
    }

    private static void DFS(int now, int target, int move) {
        // 현재 노드를 기준으로
        ArrayList<Info> infoList = nodes[now];
        check[now] = true;

        for(Info info : infoList) {
            // 목적지와 거리를 가져온다.
            int des = info.destination;
            int dis = info.distance;

            // 이미 방문한 곳이면 패스
            if (check[des]) continue;

            // 목적지라면 그 거리를 체크해준다. 이미 목적지를 찾았으면 그 다음은 볼 필요가 없음
            if (des == target) {
                ans = Math.min(ans, move + dis);
                continue;
            }

            // 목적지가 아니라면 계속해서 탐색
            DFS(des, target, move + dis);
        }
    }
}

class Info {
    int destination;
    int distance;

    public Info(int destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }
}
