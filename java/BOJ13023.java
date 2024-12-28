/******************************************************************************

 Online Java Compiler.
 Code, Compile, Run and Debug java program online.
 Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/
import java.util.*;

public class Main
{
    private static ArrayList<Integer>[] relationList;
    private static boolean check[];
    private static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        // 최초 초기화 - relationList는 모든 인원들에 대해 이 사람의 친구를 저장한다.
        relationList = new ArrayList[N];
        check = new boolean[N];
        for(int i=0; i<N; i++) relationList[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            relationList[a].add(b); // 각 사람들의 친구 관계를 저장
            relationList[b].add(a);
        }

        // 모든 사람들에 대해서 A-B-C-D-E 관계가 있는지를 체크한다.
        for(int i=0; i<N; i++) {
            DFS(0, i);
        }

        System.out.println(ans);
    }

    private static void DFS(int depth, int now) {
        if (depth == 4) { // 4명까지 친구로 확인되면 정답
            ans = 1;
            return;
        }

        if (ans == 1) return;

        // 백트레킹 지금 나의 탐색 여부 확인
        check[now] = true;
        ArrayList<Integer> friendList = relationList[now]; // 내 친구들 확인

        // 그래서 그 친구들 모두에 대해 확인하면 된다.
        for(int i=0; i<friendList.size(); i++) {
            int friend = friendList.get(i);

            if (!check[friend]) {
                DFS(depth+1, friend); // 이게 되는 이유는 한번 이 사람에 대해 체크하게 되면 그 다음 친구에 대해 확인할 때 일자로 유지가 가능하다.
            }
        }

        check[now] = false;
    }
}
