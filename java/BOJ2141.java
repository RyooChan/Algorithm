/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = Integer.parseInt(sc.nextLine());
        
        HashMap<Integer, Integer> hm = new HashMap<>();

        // 전체 사람 수
        long total = 0;
        for(int i=0; i<N; i++) {
          String input = sc.nextLine();
          String[] spl = input.split(" ");
          total += Integer.parseInt(spl[1]);  // 전체 인구수를 구하면서
          hm.put(Integer.parseInt(spl[0]), Integer.parseInt(spl[1])); // 마을거리,사람수 로 hashmap 저장
        }

        // 마을 거리를 기준으로 정렬한다.
        // 이유는 이렇게 작은 숫자대로 가다가 마을 사람의 숫자가 딱 절반에 해당하면 그게 가장 적은 이동하는 거리이기 떄문
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(hm.entrySet());
        entryList.sort(Map.Entry.comparingByKey());

        // 지금 마을까지의 사람수 계산
        long now = 0;
        for(Map.Entry<Integer, Integer> entry : entryList) {
          int dis = entry.getKey();
          int count = entry.getValue();
          now += count;
          if (now >= (total+1)/2) { // 그래서 전체 인구 절반이 되면
            System.out.println(dis); // 그게 정답임
            return;
          }
        }
    }
}
