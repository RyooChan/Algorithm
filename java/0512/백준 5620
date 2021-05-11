/*
가장 가까운 두 점의 거리 성공출처다국어분류번외
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	2407	769	427	40.245%
문제
평면상에 n개의 점 (P1, .... ,  Pn) 이 놓여져있다고 했을 때, 거리가 최소인 두 개의 점을 구하고 그 거리를 알고 싶다.

입력
입력은 첫 번째 줄에 정수로 된 점의 개수 n이 주어진다.

두 번째 줄부터 n+1번째 줄까지 2개의 정수 x,y가 공백을 사이에 두고 주어진다. 

i+1번째 줄은 Pi 의 x,y 좌표를 의미하고 n개의 점에 대해서 주어지게 된다.

점의 개수는 2 ≦ n ≦ 500000 , 좌표의 범위는 -10000 ≦ x,y ≦10000로 주어진다.

또한, 모든 점의 좌표는 같은 것이 없이 다른 것으로 한다.

출력
가장 가까운 두 점 사이의 거리의 제곱을 출력하시오.

예제 입력 1 
3
5 5
0 0
-3 -4
예제 출력 1 
25
예제 입력 2 
2
0 0
1 1
예제 출력 2 
2
*/

// 풀이
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Point[] points = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			points[i] = new Point(x, y);
		}
		Arrays.sort(points, (p1, p2) -> p1.x - p2.x);

		TreeSet<Point> set = new TreeSet<>((p1, p2) -> ((p1.y == p2.y) ? p1.x - p2.x : p1.y - p2.y));

		set.add(points[0]);
		set.add(points[1]);

		int ans = dist(points[0], points[1]);

		int start = 0;

		for (int i = 2; i < N; i++) {
			Point now = points[i];

			while (start < i) {
				Point point = points[start];
				int k = now.x - point.x;

				if (k * k > ans) {
					set.remove(point);
					start++;
				} else {
					break;
				}
			}

			int d = (int) Math.sqrt((double) ans) + 1;

			Point from = new Point(-100000, now.y - d);
			Point to = new Point(100000, now.y + d);

			for (Point point : set.subSet(from, to)) {
				ans = Math.min(ans, dist(now, point));
			}

			set.add(now);
		}

		bw.write(ans + "\n");
		bw.close();
		br.close();
	}

	public static int dist(Point p, Point q) {
		return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
	}

}
