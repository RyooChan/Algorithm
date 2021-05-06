/*
수들의 합 성공분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	13825	5714	4811	42.913%
문제
서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?

입력
첫째 줄에 자연수 S(1 ≤ S ≤ 4,294,967,295)가 주어진다.

출력
첫째 줄에 자연수 N의 최댓값을 출력한다.

예제 입력 1 
200
예제 출력 1 
19
*/

// 풀이
import java.util.*;

public class Main {
    public static void main(String args[]) {
    // 가장 많은 수를 구하려면 1부터 될때까지 쭉 구하다가 원하는 숫자보다 커졌을 때 빠져나가고, 커진 만큼에 해당하는 숫자를 빼주면 된다.
        int cnt = 0;
        long num = 0;
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        
        // 무조건 N이 num보다 작아야 한다. 왜냐면 정확히 만들어지는 경우 cnt-1이 아니라 cnt를 구해야 하는데, 그러는 것 보다 한번 더 process를 진행하고 빼는게 깜끔하기 때문이다.
        while(num <= N){
            cnt++;
            num += cnt;
        }
        
      
      System.out.println(cnt-1);
    }
}
