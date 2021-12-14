/*
가르침 성공분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB (하단 참고)	19680	5249	3140	24.658%
문제
남극에 사는 김지민 선생님은 학생들이 되도록이면 많은 단어를 읽을 수 있도록 하려고 한다. 그러나 지구온난화로 인해 얼음이 녹아서 곧 학교가 무너지기 때문에, 김지민은 K개의 글자를 가르칠 시간 밖에 없다. 김지민이 가르치고 난 후에는, 학생들은 그 K개의 글자로만 이루어진 단어만을 읽을 수 있다. 김지민은 어떤 K개의 글자를 가르쳐야 학생들이 읽을 수 있는 단어의 개수가 최대가 되는지 고민에 빠졌다.

남극언어의 모든 단어는 "anta"로 시작되고, "tica"로 끝난다. 남극언어에 단어는 N개 밖에 없다고 가정한다. 학생들이 읽을 수 있는 단어의 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 단어의 개수 N과 K가 주어진다. N은 50보다 작거나 같은 자연수이고, K는 26보다 작거나 같은 자연수 또는 0이다. 둘째 줄부터 N개의 줄에 남극 언어의 단어가 주어진다. 단어는 영어 소문자로만 이루어져 있고, 길이가 8보다 크거나 같고, 15보다 작거나 같다. 모든 단어는 중복되지 않는다.

출력
첫째 줄에 김지민이 K개의 글자를 가르칠 때, 학생들이 읽을 수 있는 단어 개수의 최댓값을 출력한다.

예제 입력 1 
3 6
antarctica
antahellotica
antacartica
예제 출력 1 
2
예제 입력 2 
2 3
antaxxxxxxxtica
antarctica
예제 출력 2 
0
예제 입력 3 
9 8
antabtica
antaxtica
antadtica
antaetica
antaftica
antagtica
antahtica
antajtica
antaktica
예제 출력 3 
3

*/

// 풀이
import java.util.*;

public class Main {
	public static int N;
	public static int K;
  // 체크할 알파벳의 개수 = a~z까지 26개
	public static boolean[] check = new boolean[26];
	public static String[] word;
	public static int ans = 0;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		word = new String[N]; 
		
		for(int i=0; i<N; i++)
			word[i] = sc.next();
		
    // 먼저 입력을 모두 받고, 남극 문자는 앞의 5개를 최소한 배워야 한다. 따라서 K는 5를 빼주어, 무조건 배우는 5자를 고려해 준다.
		K -= 5;

    // 해당 알파뱃들은 무조건 배워야 하기 때문에 해당하는 위치를 true해 준다. 즉 모든 글자에 공통으로 들어간다는 뜻이다.
		check['a'-'a'] = true;
		check['t'-'a'] = true;
		check['n'-'a'] = true;
		check['i'-'a'] = true;
		check['c'-'a'] = true;
		
		DFS(0, 0);
		System.out.println(ans);
		
	}
  
  // DFS는 시작위치와 현재까지 카운트를 생각한다.
	public static void DFS(int start, int count) {
    // 현재 DFS level이 배울 수 있는 글자 개수 K개에 도달한 경우
		if ( count == K ) {
      // 현재까지의 값을 저장할 now를 선언한다.
			int now = 0;
      // 모든 문자에 대해 생각해 준다.
			for(int i=0; i<N; i++) {
        // 모든 문자가 현재까지 check한 알파뱃으로 만들 수 있으면 'can'이 true, 만들 수 없으면 false이다.
				boolean can = true;
        // 현재 문자의 길이까지 알파뱃을 판단하여 만들 수 없으면 false를 return하면 된다.
				for(int j=0; j<word[i].length(); j++) {
					if( !check[word[i].charAt(j)-'a'] ) {
						can = false;
						break;
					}
				}
        // 해당 문자를 만들 수 있으면 now가 하나 늘어난다.
				if( can )
					now++;
			}
      // 이렇게 해당 count까지 판단한 DFS의 마지막 확인에서 만들 수 있다고 판단한 단어가 현재 최대값보다 많으면 바꾸어 준다.
			if( ans < now ) {
				ans = now;
				return;
			}
		}
		
    // 0~26까지 모두 확인, 자기 시작점부터 맨 뒤까지, 또 그 시작점부터 맨 뒤까지...이렇게 하면 K개의 단어를 배우는 모든 경우를 탐색 가능하다.
		for(int i=start; i<26; i++) {
			if( !check[i] ) {
				check[i] = true;
				DFS(i, count+1);
				check[i] = false;
			}
		}
		
	}
	
}

