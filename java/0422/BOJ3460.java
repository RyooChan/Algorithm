/*이진수 성공출처다국어분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	5154	3274	2895	64.491%
문제
양의 정수 n이 주어졌을 때, 이를 이진수로 나타냈을 때 1의 위치를 모두 찾는 프로그램을 작성하시오. 최하위 비트(least significant bit, lsb)의 위치는 0이다.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, n이 주어진다. (1 ≤ T ≤ 10, 1 ≤ n ≤ 106)

출력
각 테스트 케이스에 대해서, 1의 위치를 공백으로 구분해서 줄 하나에 출력한다. 위치가 낮은 것부터 출력한다.

예제 입력 1 
1
13
예제 출력 1 
0 2 3*/

// 풀이
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int j=0; j<T; j++) {
			int N = sc.nextInt();
			String ans = "";
			String a = Integer.toBinaryString(N);
			
			for(int i=a.length()-1; i>=0; i--) {
				if(a.charAt(i) == '1') ans+= (a.length()-i-1)+" ";
			}
			System.out.println(ans);
			
		}
	}
}
