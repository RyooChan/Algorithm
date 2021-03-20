/*
카드 정렬하기 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	11044	3888	3149	36.384%
문제
정렬된 두 묶음의 숫자 카드가 있다고 하자. 각 묶음의 카드의 수를 A, B라 하면 보통 두 묶음을 합쳐서 하나로 만드는 데에는 A+B 번의 비교를 해야 한다. 이를테면, 20장의 숫자 카드 묶음과 30장의 숫자 카드 묶음을 합치려면 50번의 비교가 필요하다.

매우 많은 숫자 카드 묶음이 책상 위에 놓여 있다. 이들을 두 묶음씩 골라 서로 합쳐나간다면, 고르는 순서에 따라서 비교 횟수가 매우 달라진다. 예를 들어 10장, 20장, 40장의 묶음이 있다면 10장과 20장을 합친 뒤, 합친 30장 묶음과 40장을 합친다면 (10 + 20) + (30 + 40) = 100번의 비교가 필요하다. 그러나 10장과 40장을 합친 뒤, 합친 50장 묶음과 20장을 합친다면 (10 + 40) + (50 + 20) = 120 번의 비교가 필요하므로 덜 효율적인 방법이다.

N개의 숫자 카드 묶음의 각각의 크기가 주어질 때, 최소한 몇 번의 비교가 필요한지를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100,000) 이어서 N개의 줄에 걸쳐 숫자 카드 묶음의 각각의 크기가 주어진다. 숫자 카드 묶음의 크기는 1,000보다 작거나 같은 양의 정수이다.

출력
첫째 줄에 최소 비교 횟수를 출력한다.

예제 입력 1 
3
10
20
40
예제 출력 1 
100
*/

// 풀이
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.IOException; 
public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int first = Integer.parseInt(br.readLine());
    // 풀이 방법은 가장 작은 카드 뭉치부터 비교해 나가는 것
    // 추가적으로 카드 두 개를 이용해 만든 뭉치보다 더 작은 뭉치가 있을 경우 {{{ex (10 + 20)과 25의 경우, 25는 10, 20보다 크지만 (10+20)보다 작음 }}} 그것부터 우선하도록 우선순위 큐 사용
		PriorityQueue<Integer> card = new PriorityQueue<Integer>();
		
    // 우선순위 큐에 값들을 오름차순으로 정렬되게 한다.
		for(int i=0; i<first; i++)
			card.add(Integer.parseInt(br.readLine()));
		
    // 카드를 확인하는 confirm변수
		int confirm = 0;
		
    // 두 개씩 빼면서 검사할 예정이라서 size가 1보다 클 때까지 사용한다.
		while(card.size() > 1)
		{
    // 두 수 A, B를 계속 빼면서 총 검사 개수를 구한다. 추가로 구해진 뭉치는 다시 우선순위 큐로 돌아가 다른 수들과 비교하여 맞는 위치를 찾아가게 된다.
			int A = card.poll();
			int B = card.poll();
			confirm += (A+B);
			card.add(A+B);
		}
		
		System.out.println(confirm);
		
	}

}
