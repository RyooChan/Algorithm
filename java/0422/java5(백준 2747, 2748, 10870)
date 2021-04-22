//문제는 피보나치 수열에 관한 것들
// 피보나치 1, 2, 5번이다
// 3, 4는 매우 큰 수를 사용하는 것으로 보아 DP구현 문제와 관련이 없는 것으로 판단하였고, 실제로 이렇게 풀수는 없어서 다른 방식으로 풀어야 할 것 같다.

//풀이
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long fibo[] = new long[91]; // 여기서 선언 시 문제의 N에 대해 N+1로 선언해주면 잘 동작한다.
		
    // 메모이제이션을사용하여 풀도록 한다.
		fibo[0] = 0;
		fibo[1] = 1;
		
    // 즉 N번쨰 피보나치는 fibo[N]이다
		for(int i=2; i<N+1; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		System.out.println(fibo[N]);
		
	}
}
