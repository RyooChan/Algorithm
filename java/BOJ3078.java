/******************************************************************************

 Online Java Compiler.
 Code, Compile, Run and Debug java program online.
 Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/
import java.util.*;

public class Main{
    public static void main(String[] args) {
        // 30000 개의 입력. int 범위를 벗어날 수 있다.
        long ans = 0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] users = new int[N]; // 친구 이름이 뭔지는 안중요하고 이름의 길이가 중요함

        for(int i=0; i<N; i++) {
            users[i] = sc.next().length(); // 사람들의 이름을 저장한다.
        }

        // 현재 위치 사람의 친구들의 이름 갯수를 저장하는 HashMap
        HashMap<Integer, Integer> lengthCnt = new HashMap<>();

        for(int i=0; i<K+1; i++) {
            // 0번 녀석 본인을 포함하고 그 K번 아래까지 친구들을 이름 갯수 저장
            lengthCnt.put(users[i], lengthCnt.getOrDefault(users[i], 0) + 1);
        }

        for(int i=0; i<N; i++) {
            int nowLength = users[i]; // 현재 녀석 봐서
            lengthCnt.put(nowLength, lengthCnt.get(nowLength) - 1); // 그녀석의 이름은 고려하지 않고
            int near = lengthCnt.get(nowLength); // 나머지 친구들의 이름 갯수 중 현재 친구와 같은 갯수를 구하면
            ans += near; // 가장 친한 친구가 된다.
            if(i+K+1 < N) { // 그리고 아래로 가면서 다음 사람의 K만큼 거리의 친구를 추가하면 된다.
                int nextWindow = users[i+K+1];
                lengthCnt.put(nextWindow, lengthCnt.getOrDefault(nextWindow, 0) + 1);
            }
        }

        System.out.println(ans);
    }
}
