import java.util.*;

public class Main
{
    private static char map[][];
    private static boolean checker[][];
    private static int N;
    private static boolean ans = false;
    private static List<int[]> teachers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new char[N][N];
        checker = new boolean[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0;j<N; j++) {
                String input = sc.next();
                char inputChr = input.charAt(0);

                // 선생의 위치를 미리 기억해둔다.
                if(inputChr == 'T') teachers.add(new int[]{i, j});

                map[i][j] = inputChr;
            }
        }

        // 확인하기
        checker(0, 0, 0);

        if(ans) System.out.println("YES");
        else System.out.println("NO");
    }

    private static void checker(int x, int y, int count) {
        // 이미 안들킬 수 있으면 더 확인 필요 없음
        if (ans) return;

        // 장애물 3개 세웠으면 확인해보기
        if (count == 3) {
            ans = isAvoidable();
            return;
        }

        // 모든 장애물을 둘 수 있는 위치에 설치한다.
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                // 빈공간이면
                if (!checker[i][j] && map[i][j] == 'X') {
                    // 장애물 설치 후 여기 체크해봤는지 확인
                    map[i][j] = 'D';
                    checker[i][j] = true;

                    // 그 위치에 대해 더 장애물을 둬야 하는지 / 아니면 체크할지 검사
                    checker(i, j, count+1);

                    // 여기 검사 다 되었으면 다시 원상복구
                    map[i][j] = 'X';
                    checker[i][j] = false;
                }
            }
        }
    }

    // 피할 수 있는지 확인하기
    private static boolean isAvoidable() {

        // 모든 선생 위치에 대해
        for(int i=0; i<teachers.size(); i++) {
            int[] coor = teachers.get(i);
            int x = coor[0];
            int y = coor[1];

            // 상하좌우 검사
            for(int j=y; j>=0; j--) {
                if (map[x][j] == 'D') break;
                else if (map[x][j] == 'S') return false;
            }
            for(int j=y; j<N; j++) {
                if (map[x][j] == 'D') break;
                else if (map[x][j] == 'S') return false;
            }
            for(int j=x; j>=0; j--) {
                if (map[j][y] == 'D') break;
                else if (map[j][y] == 'S') return false;
            }
            for(int j=x; j<N; j++) {
                if (map[j][y] == 'D') break;
                else if (map[j][y] == 'S') return false;
            }
        }

        return true;
    }
}
