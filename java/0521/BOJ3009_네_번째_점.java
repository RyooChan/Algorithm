/*
네 번째 점 성공출처다국어분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	17187	12258	11135	72.964%
문제
세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.

입력
세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.

출력
직사각형의 네 번째 점의 좌표를 출력한다.

예제 입력 1 
30 20
10 10
10 20
예제 출력 1 
30 10
*/

// 풀이
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x1, x2, x3;
		int y1, y2, y3;
		int ansX, ansY;
		x1 = sc.nextInt();
		y1 = sc.nextInt();
		x2 = sc.nextInt();
		y2 = sc.nextInt();
		x3 = sc.nextInt();
		y3 = sc.nextInt();

		if(x1 == x2) ansX = x3;
		else if(x2 == x3) ansX = x1;
		else ansX = x2;
		if(y1 == y2) ansY = y3;
		else if(y2 == y3) ansY = y1;
		else ansY = y2;
		
		System.out.printf("%d %d", ansX, ansY);
	}
	
	
}
