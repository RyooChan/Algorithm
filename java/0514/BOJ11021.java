/*A+B - 7 성공분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	91945	47410	42625	52.326%
문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다.

각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)

출력
각 테스트 케이스마다 "Case #x: "를 출력한 다음, A+B를 출력한다. 테스트 케이스 번호는 1부터 시작한다.

예제 입력 1 
5
1 1
2 3
3 4
9 8
5 2
예제 출력 1 
Case #1: 2
Case #2: 5
Case #3: 7
Case #4: 17
Case #5: 7
*/

// 풀이
import java.util.Scanner;

public class Main{ 

	public static void main(String[] args) {
		
		int A, B;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for(int i=0; i<N; i++){
            A = sc.nextInt();
            B = sc.nextInt();
            System.out.println("Case #" + (i+1) + ": " + (A+B));
        }
        
	}

}
