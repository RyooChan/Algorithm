/*
N과 M (2) 성공
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	512 MB	26720	20173	14735	74.938%
문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
고른 수열은 오름차순이어야 한다.
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
1 2
1 3
1 4
2 3
2 4
3 4
예제 입력 3 
4 4
예제 출력 3 
1 2 3 4
*/


// 풀이
import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int M;
	public static int num[];

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[M];
		
		dfs(1, 0);	// 현재 숫자, 배열의 위치 -> 1~N까지 주어지니까 1로 시작한다.
		
	}
	public static void dfs(int nowNum, int arrLoc) {
		if(arrLoc==M) {		// 현재 위치가 마지막에 있다면(즉, 하나의 순열이 모두 완성되는 경우) 출력해준다.
			for(int i : num) System.out.printf("%d ", i);
			System.out.println();
			return;		// 출력이 완료되면 이번 순열에서는 나가주면 된다.
		}
		
		for(int i=nowNum; i<=N; i++) {	// 1부터 마지막 숫자까지 진행된다.
			num[arrLoc] = i;		// 현재 숫자부터 배열에 넣고
			dfs(i+1, arrLoc+1);		// 다음 배열에 들어갈 숫자를 구하기 위한 dfs(혹은 배열이 안성되면 출력)
		}
	}

}
