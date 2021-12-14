/*
보석 도둑 성공출처다국어분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	16270	3753	2612	22.442%
문제
세계적인 도둑 상덕이는 보석점을 털기로 결심했다.

상덕이가 털 보석점에는 보석이 총 N개 있다. 각 보석은 무게 Mi와 가격 Vi를 가지고 있다. 상덕이는 가방을 K개 가지고 있고, 각 가방에 담을 수 있는 최대 무게는 Ci이다. 가방에는 최대 한 개의 보석만 넣을 수 있다.

상덕이가 훔칠 수 있는 보석의 최대 가격을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 주어진다. (1 ≤ N, K ≤ 300,000)

다음 N개 줄에는 각 보석의 정보 Mi와 Vi가 주어진다. (0 ≤ Mi, Vi ≤ 1,000,000)

다음 K개 줄에는 가방에 담을 수 있는 최대 무게 Ci가 주어진다. (1 ≤ Ci ≤ 100,000,000)

모든 숫자는 양의 정수이다.

출력
첫째 줄에 상덕이가 훔칠 수 있는 보석 가격의 합의 최댓값을 출력한다.

예제 입력 1 
3 2
1 65
5 23
2 99
10
2
예제 출력 1 
164
*/

// 풀이
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {	
	public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int gem[][] = new int[N][2];
		int bag[] = new int[K];
    // 답이 int범위 밖이 나올 수 있어 long으로 사용
		long ans = 0;
    // 우선순위 큐를 내림차순으로 배열할 것이다.
		PriorityQueue<Integer> gemval = new PriorityQueue<>(Comparator.reverseOrder());

		for(int i=0; i<N; i++) {
			st =  new StringTokenizer(br.readLine());
			gem[i][0] = Integer.parseInt(st.nextToken());;
			gem[i][1] = Integer.parseInt(st.nextToken());;
		}
		
		for(int i=0; i<K; i++)
			bag[i] = Integer.parseInt(br.readLine());

    // 먼저 gem[i][0]는 무게, gem[i][1]는 가치이다.
    // 가벼운 가방부터 확인하여 그 가방에 들어갈 수 있는 무게를 모두 파악하고, 해당 무게 중 가치가 높은 순서대로 넣으면 가장 먼저 나오는 보석이 정답이 된다.
    // 가벼운 가방부터 확인하는 이유는 무거운 가방이 뒤로 가면서 확인하면 이전의 답들을 미리 우선순위 큐에 넣어두고 확인하면서 꺼낼 수 있기 때문이다.
    
    // 먼저 gem을 0번 인덱스 즉, 무게 순서대로 오름차순 배열한다.
		Arrays.sort(gem, Comparator.comparingInt(o1 -> o1[0]));
    // 가방도 오름차순 배열한다.
		Arrays.sort(bag);
    
    // 보석을 확인할 adder이다
		int adder = 0;
		
		for(int i : bag)
		{
    // 가벼운 가방부터 꺼내서 그곳에 들어갈 가장 무거운 보석까지 확인하여 넣는다.
			while(adder < N && (gem[adder][0] <= i))
				gemval.offer(gem[adder++][1]);
			
      // 그리고 만약 가방에 보석이 들어가지 않으면 답은 없고, 내림차순 배열의 가장 위의 보석이 답이 될것이다
				if(!gemval.isEmpty())
					ans += gemval.poll();
		}

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
		
	}

}
	
