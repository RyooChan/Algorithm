/*
부분합 성공출처다국어분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
0.5 초 (하단 참고)	128 MB	28543	7370	5241	25.506%
문제
10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다. 이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N (10 ≤ N < 100,000)과 S (0 < S ≤ 100,000,000)가 주어진다. 둘째 줄에는 수열이 주어진다. 수열의 각 원소는 공백으로 구분되어져 있으며, 10,000이하의 자연수이다.

출력
첫째 줄에 구하고자 하는 최소의 길이를 출력한다. 만일 그러한 합을 만드는 것이 불가능하다면 0을 출력하면 된다.

예제 입력 1 
10 15
5 1 3 5 10 7 4 9 2 8
예제 출력 1 
2
*/

// 풀이
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N  = sc.nextInt();
		long S = sc.nextLong();
		// 합 sum
    long sum = 0;
    // 해당 sum을 만들때 들어간 숫자의 개수 length
		int length = 0;
    // 최소값 min
		int min = N;
    // 주어진 숫자로 S를 만들 수 있으면 make는 true
		boolean make = false;
		
    // 입력 개수 N+1개. 딱 배열이 끝날 떄 sum을 완성하는 경우 문제 발생 가능성을 없애기 위해 +1을 해 주었다.
		int input[] = new int[N+1];

		for(int i=0; i<N; i++)
			input[i] = sc.nextInt();
		
    
		for(int i=0; i<N+1; i++) {
    // 현재 합 sum이 S보다 작은 경우 숫자를 더해주고 길이가 늘어난다.
			if(sum < S) {
				sum += input[i];
				length++;
			} 
			else { // 길이가 같은 경우 맨 앞의 숫자를 뺴준다.
				make = true; // 주어진 숫자로 S를 만들 수 있다.
				min = Math.min(min, length);  // 최소의 길이를 매번 판별해 준다.
				sum -= input[i-length]; // 맨 앞을 빼준다.
				length--; // 길이가 줄어든다.
				i--; // 해당 배열을 다시 확인 가능하도록 process를 이전으로
			}
		}
        
    // 주어진 숫자들로 못만들면 0을 return
		if(!make) min = 0;
		System.out.println(min);
		
	}
}
