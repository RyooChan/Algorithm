/*
잃어버린 괄호 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	23524	11171	9068	47.953%
문제
세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.

그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.

괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

입력
첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다. 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.

출력
첫째 줄에 정답을 출력한다.

예제 입력 1 
55-50+40
예제 출력 1 
-35
*/

// 풀이
import java.util.*;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();
		
		// +를 괄호로 묶고 -를 계산하게 되면 최대한 작은 숫자를 만들 수 있다.
		// 즉 처음 값을 뺴고 뒤에서 -들을 한번에 더해 뺴주면 된다.
		
		// -를 계산할 것이기 때문에 입력받은 N을 -로 먼저 나누어 준다.
		String num[] = N.split("-");
		
		// 혹시 처음에 -로 시작하지 않는 경우 이는 양수이므로 처음 -이전까지의 모든 수의 합을 구해주기 위한 plus를 찾는다.
		String plus[] = num[0].split("\\+");
		
		// plus해 줄 처음 값을 선언한다.
		int first = 0;
		
		// 첫번째 plus덩어리를 만들기 위해 나누어진 배열을 다 더해 plus에 더해준다.
		for(String i : plus)
			first += Integer.parseInt(i);
		
		// -덩어리들을 계산하는 sum, 이렇게 구해진 총합을 first에서 뺴주면된다.
		int sum = 0;
		
		// 처음 first를 제외한 덩어리들의 최종 결과값을 구한다.
		// 이 값 부터는 모두 -연산되기 때문에 덩어리 a, b, c를 구했다 치면 first - a - b - c는 쉽게 first- (a, b, c)로 구할 수 있다.
		for(int i=1; i<num.length; i++)
		{
			// 0뒤의 1부터 진행되는 +덩어리들의 계산이다. 위와 비슷하게 진행된다.
			String pplus[] = num[i].split("\\+");
				for(String j : pplus)
					sum += Integer.parseInt(j);
		}
		
		// 처음 덩어리 빼기 이후 모든 덩어리가 최소값이다.
		int ans = first - sum;

		System.out.println(ans);
	}

}
