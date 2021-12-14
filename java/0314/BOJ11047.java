/*
동전 0 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	46784	24878	19654	52.811%
문제
준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.

동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)

둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)

출력
첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.

예제 입력 1 
10 4200
1
5
10
50
100
500
1000
5000
10000
50000
예제 출력 1 
6
예제 입력 2 
10 4790
1
5
10
50
100
500
1000
5000
10000
50000
예제 출력 2 
12
*/

// 풀이
import java.util.*;
public class Main {

	public static void main(String[] args) {
		
        // -----입력-----
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int price = sc.nextInt();
		Integer input[] = new Integer[N];
		for(int i=0; i<N; i++)
		{
			input[i] = sc.nextInt();
		}
        // --------------
		
        // 가장 큰 동전으로 값을 빼는 편이 작은 답을 가질 수 있기에 내림차순 정렬
		Arrays.sort(input, Collections.reverseOrder());
        
        // 동전 값을 작게 만들며 값을 대조할 때 쓰는 count
		int count = 0;
        // 해당 동전이 사용 가능한 경우 그 값을 만들기 위해 얼마나 필요할지 쓰는 divide
		int divide = 0;
        // 정답을 기입할 answer
		int ans = 0;
		
        // 값을 빼면서 0이 될 때 까지 시행해 준다.
		while(price!=0)
		{
            // 만약 input[count]에 해당하는 동전이 price를 나누었을 때 0보다 크면 그 동전보다 price가 크다는 것으로 이를 나누면 필요한 최대 양을 구할 수 있음.
			if(price / input[count] != 0)
			{
                // 그래서 필요한 동전 양 divide는 해당 동전으로 price를 나눠서 가짐
				divide = price / input[count];
                // 그리고 값은 그 동전의 값만큼 빼준다.
				price -= divide * input[count];
                // 정답은 이 동전의 총 개수이다.
				ans += divide;
			}
            // count가 진행될수록 내림차순으로 정렬된 동전의 값은 점점 작아질 것이다.
			count++;
		}
		
		System.out.println(ans);
	}

}
