/*
소수 성공출처분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	48527	18640	16194	39.455%
문제
자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.

예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 이들 소수의 합은 620이고, 최솟값은 61이 된다.

입력
입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다.

M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.

출력
M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다. 

단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.

예제 입력 1 
60
100
예제 출력 1 
620
61
예제 입력 2 
64
65
예제 출력 2 
-1
*/

// 풀이
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
    // 합, 최소값
		int sum = 0;
		int min = 0;
    // 최소값 판단 + 값 유무
		boolean minCheck = true;
		
    // 에라토스테네스의 체 사용
		int[] arr = new int[B+1];
		for(int i=2; i<=B; i++)
			arr[i] = i;
		// 2부터 진행해서 2의 배수들 지우고 3의 배수들 지우고 5의 배수들 지우고......그렇게 진행하면 0이면 소수가 아니고 0이 아니면 소수
		for(int i=2; i<=B; i++) {
			if(arr[i] == 0) continue;
			
      // 최소값 판단 + minCheck가 false면 소수가 있는것이다.
			if(minCheck && i>=A) {
				min = i;
				minCheck = false;
			}
			// 합 구하기
			if(i >= A) {
				sum += i;
			}
				
			// 소수가 들어가는 배수 다 지워주기
			for(int j=2*i; j<=B; j+=i) {
				arr[j] = 0;
			}
		}
    // 최소값 없으면 -1, 있으면 값 반환
		if(minCheck)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
		
	}
}
