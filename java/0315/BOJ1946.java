/*
신입 사원 성공출처분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	256 MB	21289	6617	4879	31.887%
문제
언제나 최고만을 지향하는 굴지의 대기업 진영 주식회사가 신규 사원 채용을 실시한다. 인재 선발 시험은 1차 서류심사와 2차 면접시험으로 이루어진다. 최고만을 지향한다는 기업의 이념에 따라 그들은 최고의 인재들만을 사원으로 선발하고 싶어 한다.

그래서 진영 주식회사는, 다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다는 원칙을 세웠다. 즉, 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다.

이러한 조건을 만족시키면서, 진영 주식회사가 이번 신규 사원 채용에서 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 20)가 주어진다. 각 테스트 케이스의 첫째 줄에 지원자의 숫자 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개 줄에는 각각의 지원자의 서류심사 성적, 면접 성적의 순위가 공백을 사이에 두고 한 줄에 주어진다. 두 성적 순위는 모두 1위부터 N위까지 동석차 없이 결정된다고 가정한다.

출력
각 테스트 케이스에 대해서 진영 주식회사가 선발할 수 있는 신입사원의 최대 인원수를 한 줄에 하나씩 출력한다.

예제 입력 1 
2
5
3 2
1 4
4 1
2 3
5 5
7
3 6
7 3
4 2
1 4
5 7
2 5
6 1
예제 출력 1 
4
3
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
		// BufferedReader사용하려면 IOException을 해주어야 한다. 혹은 try catch 사용해야한다.
    // scanner는 많은 입력을 받거나 출력을 진행하기에 느려서 시간복잡도를 맞추기 위해서 bufferedreader를 사용했다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int ans[] = new int[N];
		int first;
		
		for(int i=0; i<N; i++)
		{
			first = Integer.parseInt(br.readLine());
			ans[i] = first;
			int staff[][] = new int[first][2];
			for(int j=0; j<first; j++)
			{
                String input = br.readLine();
                StringTokenizer st = new StringTokenizer(input);
				staff[j][0] = Integer.parseInt(st.nextToken());
				staff[j][1] = Integer.parseInt(st.nextToken());
			}	
      // 이곳까지 입력을 받고, 각각의 test case마다 process 진행. 즉 끝나고 하지 않고 test case마다 하기로 했다.
			
      // 문제 풀이의 방법은 성적 - 면접 인덱스의 배열을 진행하여, 두 인덱스 모두 누군가보다 낮은 경우 탈락이다.
      // 그렇다면 성적 기준 오름차순 정렬을 진행한 뒤, 1등의 면접점수를 받아와서 2~5등 중 누군가의 면접 점수가 그보다 낮으면 탈락하게 되어 있다.
      // 만약 2등의 면접점수가 1등보다 낮은 경우, 2등은 탈락한다.
      // 혹은 2등의 면접점수가 1등보다 높은 경우, 합격이다. 그런데 3~5등까지의 면접 점수가 2등의 면접 점수보다 낮은 경우 탈락한다.
      // 각 면접 점수마다 통과할 경우 갱신시키며 진행하면 최적의 해를 구할 수 있을 것이다.
      
      // 먼저 성적 기준으로 오름차순 정렬해 준다.
			Arrays.sort(staff, Comparator.comparingInt(o1 -> o1[0]));
      // 1등의 면접점수를 받아 와 저장해준다.
			int interview = staff[0][1];
			
      // 0부터 진행이므로 j=1이면 2등부터 성적을 비교한다.
			for(int j=1; j<first; j++)
			{
        // 자기보다 성적이 높은 사람의 면접점수와 비교하여 자신이 더 높으면 갱신하고 합격, 자신이 낮으면 불합격 -> ans를 1 뺸다. 참고로 면접점수는 등수제라서 성적이랑 반대다.
				if(staff[j][1] > interview)
					ans[i]--;
				else if(staff[j][1] < interview)
					interview = staff[j][1];
			}
		
		}
		
    // 결과를 출력해 준다.
		for(int i : ans)
			bw.write(i+"\n");
		bw.flush();
		bw.close();
		
	}

}
