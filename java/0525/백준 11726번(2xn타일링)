/*
2×n 타일링 성공분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	82004	30555	22274	34.986%
문제
2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.



입력
첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

출력
첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

예제 입력 1 
2
예제 출력 1 
2
예제 입력 2 
9
예제 출력 2 
55
*/

// 풀이
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    // 결국 피보나치 수열과 비슷하게 진행된다.
    
    // 2x1, 1x2 두 가지 경우가 있다. 전체 채우는 개수를 파악하면 쉽게 풀 수 있다.
		int A = 1;
		int B = 1;
		int N = sc.nextInt();
		for(int i=0; i<N-1; i++) {
			int C = (A+B) % 10007;
			A = B;
			B = C;
		}
		System.out.println(B);
	}
	
	
}
