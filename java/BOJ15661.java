import java.util.*;

public class Main {
    private static int[][] map;
    private static List<Integer> team1 = new ArrayList<>();
    private static List<Integer> team2 = new ArrayList<>();
    private static int ans = Integer.MAX_VALUE;
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0);

        System.out.println(ans);
    }

    private static void dfs(int index) {
        // 모든 팀을 나눈 후에는
        if (index == N) {
            // 각 팀의 능력치를 계산하고
            int team1Sum = calculateScore(team1);
            int team2Sum = calculateScore(team2);

            // 능력치 합의 차이를 구한다.
            ans = Math.min(ans, Math.abs(team1Sum - team2Sum));
            return;
        }

        // team1에 지금 사람을 넣고, dfs 시작
        team1.add(index);
        dfs(index+1); // 다음사람에 대한 추가 or 전체 사람에 대한 확인
        team1.remove(team1.size()-1); // 이번사람에 대한 확인이 끝나면, 다시 빼준다.

        // 이사람을 다시 team2에 넣고, dfs 시작
        team2.add(index);
        dfs(index+1);
        team2.remove(team2.size()-1);
    }

    private static int calculateScore(List<Integer> team) {
        int score = 0;

        for (int i=0; i<team.size(); i++) {
            for (int j=0; j<team.size(); j++) {
                score += map[team.get(i)][team.get(j)];
            }
        }

        return score;
    }
}
