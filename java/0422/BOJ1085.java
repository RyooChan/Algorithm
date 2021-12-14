/*직사각형에서 탈출 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	34839	20072	17990	58.192%
문제
한수는 지금 (x, y)에 있다. 직사각형의 왼쪽 아래 꼭짓점은 (0, 0)에 있고, 오른쪽 위 꼭짓점은 (w, h)에 있다. 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 x, y, w, h가 주어진다.

출력
첫째 줄에 문제의 정답을 출력한다.

제한
1 ≤ w, h ≤ 1,000
1 ≤ x ≤ w-1
1 ≤ y ≤ h-1
x, y, w, h는 정수
예제 입력 1 
6 2 10 3
예제 출력 1 
1
*/

// 풀이
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();
    // 위 아래 오른쪽 왼쪽까지 가는 각각 최소의 경로를 구한다.
		int x_min = Math.min(x, X-x);
		int y_min = Math.min(y, Y-y);	
        
    // 그중 더 짧은게 진짜 최소경로이다.
		System.out.println(Math.min(x_min, y_min));
		
	}
}
