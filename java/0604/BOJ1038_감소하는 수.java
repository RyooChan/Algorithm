/*
감소하는 수 성공분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	512 MB	14047	3734	2969	30.090%
문제
음이 아닌 정수 X의 자릿수가 가장 큰 자릿수부터 작은 자릿수까지 감소한다면, 그 수를 감소하는 수라고 한다. 예를 들어, 321과 950은 감소하는 수지만, 322와 958은 아니다. N번째 감소하는 수를 출력하는 프로그램을 작성하시오. 0은 0번째 감소하는 수이고, 1은 1번째 감소하는 수이다. 만약 N번째 감소하는 수가 없다면 -1을 출력한다.

입력
첫째 줄에 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 N번째 감소하는 수를 출력한다.

예제 입력 1 
18
예제 출력 1 
42
*/

// 풀이
import java.util.*;

public class Main {
    static ArrayList<Long> numbers;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long ans = -1;
        
        numbers = new ArrayList<>();
        
		
        if( N <= 10 )
            ans = N;
        else if( N <= 1022 ){
            for(int i=0; i<10; i++)
                find(i, 1);
            Collections.sort(numbers);
            ans = numbers.get(N);
        }
        System.out.println(ans);
	}
	

    public static void find(long num, int level){
        if( level > 10 )
            return;
        
        numbers.add(num);
        for(int i=0; i<10; i++){
            if( num % 10 > i)
                find( (num*10)+i, level+1 );
        }
        return;
        
    }

}
