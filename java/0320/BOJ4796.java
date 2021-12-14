/*
캠핑 출처다국어분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	9731	3841	3284	39.864%
문제
등산가 김강산은 가족들과 함께 캠핑을 떠났다. 하지만, 캠핑장에는 다음과 같은 경고문이 쓰여 있었다.

캠핑장은 연속하는 20일 중 10일동안만 사용할 수 있습니다.

강산이는 이제 막 28일 휴가를 시작했다. 이번 휴가 기간 동안 강산이는 캠핑장을 며칠동안 사용할 수 있을까?

강산이는 조금 더 일반화해서 문제를 풀려고 한다. 

캠핑장을 연속하는 P일 중, L일동안만 사용할 수 있다. 강산이는 이제 막 V일짜리 휴가를 시작했다. 강산이가 캠핑장을 최대 며칠동안 사용할 수 있을까? (1 < L < P < V)

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있고, L, P, V를 순서대로 포함하고 있다. 모든 입력 정수는 int범위이다. 마지막 줄에는 0이 3개 주어진다.

출력
각 테스트 케이스에 대해서, 강산이가 캠핑장을 최대 며칠동안 사용할 수 있는지 예제 출력처럼 출력한다.

예제 입력 1 
5 8 20
5 8 17
0 0 0
예제 출력 1 
Case 1: 14
Case 2: 11
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
		
    // 값을 선입선출법으로 내보내기 위해 queue사용
		Queue<Integer> use = new LinkedList<>();
		
		// 조건에 맞춰 L=V=P=0이기 전까지 계속 돈다.
		while(true)
		{
      // 해당 Test Case의 최대 이용 날짜를 정의한다.
			int TCuse = 0;
      // 입력 받기
			String N = br.readLine();
			StringTokenizer st = new StringTokenizer(N);
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
      // 셋 다 0인 경우 탈출
			if(L==0 && V==0 && P==0)
				break;
			
      // 최대 이용 날짜수는 전체날짜(V)에서 연속된날짜(P) 중 (L)일을 이용하는 경우를 먼저 구한 뒤, 남은 날짜 중 최대 이용 날짜를 더해주면 된다.
      
      // 먼저 연속된 P일 중 L일을 사용 가능하니 최대 날짜에서 연속날짜를 뺴가며, 그 중 이용 가능 날짜를 TCuse에 더해준다.
			while(V-P > 0)
			{
				TCuse += L;
				V-=P;
			}
			
      // 그러면 남은 전체 날짜(V)가 나오는데, 이 중 이용가능 날짜(L)보다 남은 V가 큰 경우 L만큼만 이용 가능하다.
      // 그보다 같거나 작은 경우 남은 전체 날짜(V)만큼 이용 가능하다.
			if(V>L)
				TCuse += L;
			else
				TCuse += V;
			
      // 구해진 TC의날짜를 더해준다.
			use.add(TCuse);		
		}
		
    // queue를 반환하며 나타낼 것이므로 크기를 먼저 적어준다.
		int cnt = use.size();
		
    // 그 크기만큼 출력해준다.
		for(int i=0; i<cnt; i++)
			System.out.printf("Case %d: %d\n", i+1, use.poll());
		
	}

}
