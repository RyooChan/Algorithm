import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] height = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) height[i] = Integer.parseInt(st.nextToken());

        int[] canSeeCount = new int[N+1]; // 볼 수 있는 건물의 개수
        int[] nearIndex = new int[N+1]; // 가장 가까운 건물
        Arrays.fill(nearIndex, Integer.MAX_VALUE);  // 초기화

        // 지금 건물보다 높은 건물들을 보관하려는 stack
        Stack<Integer> stack = new Stack<>();

        // 왼쪽 -> 오른쪽
        for(int i=1; i<=N; i++) {
            // 현재 건물 왼쪽에 있는 애들 중 바로 앞에 있는게 지금보다 낮거나 같으면 안보임
            while(!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                stack.pop();
            }
            canSeeCount[i] += stack.size(); // 나머지 건물들은 보인다.
            if(!stack.isEmpty()) { // 그 중 가장 가까운 건물 저장
                nearIndex[i] = stack.peek();
            }
            stack.push(i); // 지금 건물은 이제 이 stack에서 가장 낮은 건물이다.
        }

        stack.clear(); // 왼쪽 다 봤으면 걍 지움

        // 오른쪽 -> 왼쪽
        for(int i=N; i>=1; i--) {
            while(!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                stack.pop();
            }
            canSeeCount[i] += stack.size(); // 반대쪽에서 보이는 건물 수 더하기
            if(!stack.isEmpty()) { // 가장 가까운 건물 확인, 가장 가까운 건물이 없으면 MAX_VALUE 였고 있으면 지금보다 먼 경우에만 갱신
                if(Math.abs(nearIndex[i] - i) > Math.abs(stack.peek() - i)) {
                    nearIndex[i] = stack.peek();
                }
            }
            stack.push(i);
        }

        for(int i=1; i<=N; i++) {
            if(canSeeCount[i] == 0) System.out.println(0);
            else System.out.println(canSeeCount[i] + " " + nearIndex[i]);
        }
    }
}
