/*
N과 M (4) 성공
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	512 MB	19400	15509	12611	80.146%
문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.
고른 수열은 비내림차순이어야 한다.
길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

예제 입력 1 
3 1
예제 출력 1 
1
2
3
예제 입력 2 
4 2
예제 출력 2 
1 1
1 2
1 3
1 4
2 2
2 3
2 4
3 3
3 4
4 4
예제 입력 3 
3 3
예제 출력 3 
1 1 1
1 1 2
1 1 3
1 2 2
1 2 3
1 3 3
2 2 2
2 2 3
2 3 3
3 3 3
*/

// 풀이
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static int N;
	public static int M;
	public static int num[];
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args)  throws IOException  {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[M];
		
		dfs(0);
		bw.flush();
	}
	
	public static void dfs(int arrLoc) throws IOException {
		if(arrLoc==M) {
			for(int i : num) bw.write(i + " ");
            bw.write("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(arrLoc>=1)
				if(num[arrLoc-1]>i)continue;  // 0번 노드는 어차피 맨앞이니까 빼고, 다음에 넣으려는 숫자보다 앞선 노드가 크면 넘어감.
			num[arrLoc] = i;
			dfs(arrLoc+1);
		}
	}

}
