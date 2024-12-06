/******************************************************************************

 Online Java Compiler.
 Code, Compile, Run and Debug java program online.
 Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/
import java.util.*;

public class Main {
    private static int ANS = 0;
    private static int COUNT;
    private static int DICE_MAX_NUM = 6;
    private static List<HashMap<Integer, Integer>> DICE = new ArrayList<>();
    private static List<HashMap<Integer, Integer>> DICE_LOC = new ArrayList<>();
    // 각 주사위가 가지고 있는 숫자와 반대편 숫자를 매핑
    private static Map<Integer, Integer> RELATION = new HashMap<>(Map.of(
        0, 5,
        5, 0,
        1, 3,
        3, 1,
        2, 4,
        4, 2
    ));

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        COUNT = Integer.parseInt(sc.nextLine());

        for(int i=0; i<COUNT; i++) {
            HashMap<Integer, Integer> hm = new HashMap<>(); // 주사위의 숫자와 위치를 매핑
            HashMap<Integer, Integer> loc = new HashMap<>(); // 주사위의 위치와 숫자를 매핑
            for(int j=0; j<DICE_MAX_NUM; j++) {
                int num = sc.nextInt();
                hm.put(j, num);
                loc.put(num, j);
            }
            DICE.add(hm);
            DICE_LOC.add(loc);
        }

        // 모든 케이스 확인
        tester(0, 0, 0);
        tester(0, 1, 0);
        tester(0, 2, 0);
        tester(0, 3, 0);
        tester(0, 4, 0);
        tester(0, 5, 0);

        System.out.println(ANS);
    }

    private static void tester(int index, int face, int ans) {
        // 현재 주사위의 숫자와 반대편 숫자를 구함
        HashMap<Integer, Integer> nowMap = DICE.get(index);
        int now = nowMap.get(face);
        int opposite = nowMap.get(RELATION.get(face));

        int bigger = Math.max(now, opposite);
        int smaller = Math.min(now, opposite);

        // 나머지는 돌리면 되는데 6, 5가 나타나는 경우만 계산해서 구해주면 된다
        if (bigger == DICE_MAX_NUM) {
            if (smaller == DICE_MAX_NUM-1) {
                ans += 4;
            } else {
                ans += 5;
            }
        } else {
            ans += 6;
        }

        // 마지막 위치면 구하기
        if (index+1 == COUNT) {
            ANS = Math.max(ANS, ans);
            return;
        }

        // 현 위치의 반대편 숫자에서 다음 주사위의 위치를 구함
        tester(index+1, DICE_LOC.get(index+1).get(opposite), ans);
    }
}
