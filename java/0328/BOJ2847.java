/*
게임을 만든 동준이 출처다국어분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	5695	2557	2270	45.382%
문제
학교에서 그래픽스 수업을 들은 동준이는 수업시간에 들은 내용을 바탕으로 스마트폰 게임을 만들었다. 게임에는 총 N개의 레벨이 있고, 각 레벨을 클리어할 때 마다 점수가 주어진다. 플레이어의 점수는 레벨을 클리어하면서 얻은 점수의 합으로, 이 점수를 바탕으로 온라인 순위를 매긴다. 동준이는 레벨을 난이도 순으로 배치했다. 하지만, 실수로 쉬운 레벨이 어려운 레벨보다 점수를 많이 받는 경우를 만들었다.

이 문제를 해결하기 위해 동준이는 특정 레벨의 점수를 감소시키려고 한다. 이렇게해서 각 레벨을 클리어할 때 주는 점수가 증가하게 만들려고 한다.

각 레벨을 클리어할 때 얻는 점수가 주어졌을 때, 몇 번 감소시키면 되는지 구하는 프로그램을 작성하시오. 점수는 항상 양수이어야 하고, 1만큼 감소시키는 것이 1번이다. 항상 답이 존재하는 경우만 주어진다. 정답이 여러 가지인 경우에는 점수를 내리는 것을 최소한으로 하는 방법을 찾아야 한다.

입력
첫째 줄에 레벨의 수 N이 주어진다. (1 ≤ N ≤ 100) 다음 N개 줄에는 각 레벨을 클리어하면 얻는 점수가 첫 번째 레벨부터 마지막 레벨까지 순서대로 주어진다. 점수는 20,000보다 작은 양의 정수이다.

출력
첫째 줄에 점수를 몇 번 감소시키면 되는지 출력한다.

예제 입력 1 
4
5
3
7
5
예제 출력 1 
6
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
        
        int num = Integer.parseInt(br.readLine());
        int[] level = new int[num];
        
        for(int i=0; i<num; i++)
        	level[i] = Integer.parseInt(br.readLine());

        // 마지막 레벨부터 판단해서 마지막 전단계는 마지막단계 점수보다 1점이 낮을 때 가장 적은 process이다.
       
        // 마지막 level의 획득점수 기입
        int now = level[num-1];
        int ans = 0;
        
        // 마지막 전 level부터 처음 레벨까지 파악한다
        for(int i=num-2; i>=0; i--)
        {
          // 기준의 now점수보다 이전 level의 점수가 낮거나 같으면
        	if(level[i] >= now)
        	{
            // 현재 점수가 기준점수보다 얼마나 큰지 파악해서 그보다 1점 더 점수를 낮춰 주면 된다.
            // 그렇다면 점수를 줄이는 횟수는 이 process를 반대로 하면 될 것이다.
        		ans += (level[i] - now + 1);
        		level[i] = now-1;
        	}
        	now = level[i];
        }
        
        
		 
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
		
	}

}
	
