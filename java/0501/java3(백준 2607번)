/*
비슷한 단어 성공출처분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	6931	1715	1368	27.676%
문제
영문 알파벳 대문자로 이루어진 두 단어가 다음의 두 가지 조건을 만족하면 같은 구성을 갖는다고 말한다.

두 개의 단어가 같은 종류의 문자로 이루어져 있다.
같은 문자는 같은 개수 만큼 있다.
예를 들어 "DOG"와 "GOD"은 둘 다 'D', 'G', 'O' 세 종류의 문자로 이루어져 있으며 양쪽 모두 'D', 'G', 'O' 가 하나씩 있으므로 이 둘은 같은 구성을 갖는다. 하지만 "GOD"과 "GOOD"의 경우 "GOD"에는 'O'가 하나, "GOOD"에는 'O'가 두 개 있으므로 이 둘은 다른 구성을 갖는다.

두 단어가 같은 구성을 갖는 경우, 또는 한 단어에서 한 문자를 더하거나, 빼거나, 하나의 문자를 다른 문자로 바꾸어 나머지 한 단어와 같은 구성을 갖게 되는 경우에 이들 두 단어를 서로 비슷한 단어라고 한다.

예를 들어 "DOG"와 "GOD"은 같은 구성을 가지므로 이 둘은 비슷한 단어이다. 또한 "GOD"에서 'O'를 하나 추가하면 "GOOD" 과 같은 구성을 갖게 되므로 이 둘 또한 비슷한 단어이다. 하지만 "DOG"에서 하나의 문자를 더하거나, 빼거나, 바꾸어도 "DOLL"과 같은 구성이 되지는 않으므로 "DOG"과 "DOLL"은 비슷한 단어가 아니다.

입력으로 여러 개의 서로 다른 단어가 주어질 때, 첫 번째 단어와 비슷한 단어가 모두 몇 개인지 찾아 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 단어의 개수가 주어지고 둘째 줄부터는 한 줄에 하나씩 단어가 주어진다. 모든 단어는 영문 알파벳 대문자로 이루어져 있다. 단어의 개수는 100개 이하이며, 각 단어의 길이는 10 이하이다.

출력
입력으로 주어진 첫 번째 단어와 비슷한 단어가 몇 개인지 첫째 줄에 출력한다.

예제 입력 1 
4
DOG
GOD
GOOD
DOLL
예제 출력 1 
2
*/

// 풀이
import java.util.*;

public class Main {
	public static void main(String[] args) {
    // 정답 ans
		int ans = 0;
		
		Scanner sc = new Scanner(System.in);
    // 처음 단어 first의 입력을 위해 나머지 값들의 입력 N을 하나 뺴준다.
		int N = sc.nextInt() - 1;
		
    // 맨 처음 단어 firstin
		String firstin = sc.next();
			
    // 처음 단어에 대해 나머지를 진행한다.
		for(int i=0; i<N; i++) {
      // 비교할 단어 입력
			String compare = sc.next();
      // 처음 단어와 이후 입력될 단어들을 배열로 만들어 저장해 준다.
			char first[] = firstin.toCharArray();
			char next[] = compare.toCharArray();
			
      // 비교하여 같은 값의 개수를 저장한 contain변수이다.
			int contain = 0;
			
      // 각각 첫번째와 다음 단어를 비교하여 같으면 contain을 늘려 주고, 다시 겹치지 않게 임의의 글자를 넣어준다. 나는 next는 1, first는 2로 넣었다.
			for(int j=0; j<next.length; j++) {
				for(int k=0; k<first.length; k++) {
					
					if(next[j] == first[k]) {
						next[j] = '1';
						first[k] = '2';
						contain++;
					}
				}
			}
			
      // 1. 처음 단어의 길이가 비교할 단어보다 길거나 같은 경우 -> 비교하여 같은 단어의 개수가 처음 단어의 길이보다 1작거나, 같으면 비슷한 단어이다.
      // 2. 처음 단어의 길이가 비교할 단어보다 짧거나 같은 경우 -> 비교하여 같은 단어의 개수가 다음 단어의 길이보다 1작거나, 같으면 비슷한 단어이다.
			if( ( contain>=first.length-1 && first.length>=next.length ) || ( contain >= next.length-1 && next.length>=first.length ) ) ans++;
			
	//		if(contain >= compare.length()-1 || contain == first.length || (contain >= first.length-1 && first.length > compare.length())) ans++;
		}
		System.out.println(ans);
	}
}
