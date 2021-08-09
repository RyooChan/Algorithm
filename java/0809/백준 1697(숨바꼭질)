/*
숨바꼭질 성공출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	117500	33078	20560	24.988%
문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

예제 입력 1 
5 17
예제 출력 1 
4
*/

// 풀이
import java.util.*;
 
public class Main {
	public static int N;
	public static int K;
	public static int check[];    // 해당 위치까지 이동하는데 걸린 횟수를 check한다.
  static public Queue<Integer> ans = new LinkedList<>();    // 그 횟수를 하나씩 저장한다. 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		check = new int[100001];    // 이거 check가 너무 크면 오류난다.... 개인적인 생각으로는 K*2+1만큼 설정하면 될줄 알았는데 꼭 이렇게 100001 이런 식으로 해야 하더라...정해져야 더 빨라서 그런듯.
        
		N = sc.nextInt();
		K = sc.nextInt();	
		if(N==K)System.out.println(0);  // 시작과 동시에 끝나면 움직일 필요가 없다.
		else bfs(N);
		
	}
	
	public static void bfs(int num) {  // 현재 위치 N
		int step;   // 현재 위치에서 이동할 step
		
		ans.add(num);   // 현재 위치를 가져온다.
		check[num] = 1; // 현재 위치까지 동하는데 걸린 횟수 <- 처음에는 당연히 0
		
		while(true) {
			int nowLoc = ans.poll();    // 현재 위치를 받아온다.
			
			for(int i=0; i<3; i++) {    // bfs 경우의 수는 앞으로한칸, 뒤로한칸, 순간이동 총 3가지
				if(i==0) step = nowLoc+1; 
				else if(i==1) step = nowLoc-1;
				else step = nowLoc*2;
				
				if(step == K) {   // 현재 이동한 위치가 내가 도달해야 할 K라면
					System.out.println(check[nowLoc]);    // 그 위치까지 가는데 걸린 check의 현재위치 nowLoc을 가져오면 된다.
					return;
				}
				
				if(step >= 0 && step < check.length && check[step]==0) {    // 음수로 가면 안된다. 또 step이 check의 크기보다 크면 에러가 발생한다. 아직 도달하지 않은 장소여야 한다.
					ans.add(step);    // 현재 위치를 일단 저장시킨다.
					check[step] = check[nowLoc] + 1;  // 도달한 곳은 이전의 위치보다 한번 더 이동한 것이다.
				}
				
			}
		}
	}
}
