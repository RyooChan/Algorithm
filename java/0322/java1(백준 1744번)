/*
수 묶기 실패분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	13933	3802	3080	26.862%
문제
길이가 N인 수열이 주어졌을 때, 그 수열의 합을 구하려고 한다. 하지만, 그냥 그 수열의 합을 모두 더해서 구하는 것이 아니라, 수열의 두 수를 묶으려고 한다. 어떤 수를 묶으려고 할 때, 위치에 상관없이 묶을 수 있다. 하지만, 같은 위치에 있는 수(자기 자신)를 묶는 것은 불가능하다. 그리고 어떤 수를 묶게 되면, 수열의 합을 구할 때 묶은 수는 서로 곱한 후에 더한다.

예를 들면, 어떤 수열이 {0, 1, 2, 4, 3, 5}일 때, 그냥 이 수열의 합을 구하면 0+1+2+4+3+5 = 15이다. 하지만, 2와 3을 묶고, 4와 5를 묶게 되면, 0+1+(2*3)+(4*5) = 27이 되어 최대가 된다.

수열의 모든 수는 단 한번만 묶거나, 아니면 묶지 않아야한다.

수열이 주어졌을 때, 수열의 각 수를 적절히 묶었을 때, 그 합이 최대가 되게 하는 프로그램을 작성하시오.

입력
첫째 줄에 수열의 크기 N이 주어진다. N은 10,000보다 작은 자연수이다. 둘째 줄부터 N개의 줄에, 수열의 각 수가 주어진다. 수열의 수는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이다.

출력
수를 합이 최대가 나오게 묶었을 때 합을 출력한다. 정답은 항상 231보다 작다.

예제 입력 1 
4
-1
2
1
3
예제 출력 1 
6
힌트
(-1)+1+(2*3)=6
*/

// 풀이
import java.util.*;
import java.io.IOException; 
public class Main {	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// ------입력--------
		int num[] = new int[N];
		for(int i=0; i<N; i++)
			num[i] = sc.nextInt();
    //--------------------

    // 양수(1보다 큰 수), 음수(0포함), 1 세 가지 Arraylist를 만든다.
		ArrayList<Integer> plus  = new ArrayList<>();
		ArrayList<Integer> minus = new ArrayList<>();
		ArrayList<Integer> one = new ArrayList<>();
		
		// 먼저 1보다 크면 plus, 1이면 one, 0부터는 minus에 담는다.
		for(int i=0; i<num.length; i++)
		{
			if(num[i] > 1)
				plus.add(num[i]);			
			else if(num[i] == 1)
				one.add(num[i]);
			else
				minus.add(num[i]);
		}

    // 문제를 푸는 방법은 이와 같다.
    // 양수의 경우 2x2부터 자기 자신과 같은 숫자가 나오고, 그보다 큰 경우 더하기보다 큰 숫자를 얻을 수 있다.
    // 1의 경우 곱하기를 하면 오히려 손해다(1은 더하기만 가능)
    // 모든 경우에서 (-)x(-)는 이득을 본다. 다만 더 작은 수(절대값이 작은 수)끼리 곱하면 더 큰 수가 나올 것이다.
    // (-)x0을 진행하면, 음수가 사라지기 때문에 이득을 볼 것이다.
    // 즉 1을 제외하고 두 가지 경우 모두 절대값이 큰 수부터 정렬해서 곱하면 큰 수를 구할 수 있을 것이다.
    
    // 이를 위해 plus는 내림차순, minus는 오름차순으로 정렬해 준다. 그러면 절대값이 큰 수가 앞으로 올 것이다.
		Collections.sort(plus, Collections.reverseOrder());
		Collections.sort(minus);
		
		// 정답 저장
		int ans = 0;
		
    // plus의 계산을 위한 iterator
		Iterator<Integer> Pelement = plus.iterator();
		
    // 1보다 큰 수들이 저장되어 있어, 큰 수부터 곱하면 된다.
    // Arraylist에서 하나씩 빼가면서 곱해준다.
    // 한번의 process에서 2개의 원소를 빼 주므로 2로 나누어서 진행한다. 참고로 이 경우 홀수 짝수 관계없이 풀 수 있다.
		for(int i=0; i<plus.size()/2; i++)
		{
			int mul = Pelement.next() * Pelement.next();
			ans += mul;
		}
    // 만약 홀수개수 였을 경우 마지막 원소가 더해지지 않았을 것이기 때문에 원소가 있을 경우 이를 빼서 더해준다.
		while(Pelement.hasNext())
			ans += Pelement.next();
		
    // 음수의 경우도 이와 비슷하게 진행해 준다.
		Iterator<Integer> Melement = minus.iterator();
		
		for(int i=0; i<minus.size()/2; i++)
		{
			int mul = Melement.next() * Melement.next();
			ans += mul;
		}
		while(Melement.hasNext())
			ans += Melement.next();
		
		// 1은 그냥 더해주면 된다.
		for(int i : one)
			ans += i;
		
		
		System.out.println(ans);
		
	}

}
	
