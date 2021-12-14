/*
패션왕 신해빈 출처다국어분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	8401	4410	3863	54.164%
문제
해빈이는 패션에 매우 민감해서 한번 입었던 옷들의 조합을 절대 다시 입지 않는다. 예를 들어 오늘 해빈이가 안경, 코트, 상의, 신발을 입었다면, 다음날은 바지를 추가로 입거나 안경대신 렌즈를 착용하거나 해야한다. 해빈이가 가진 의상들이 주어졌을때 과연 해빈이는 알몸이 아닌 상태로 며칠동안 밖에 돌아다닐 수 있을까?

입력
첫째 줄에 테스트 케이스가 주어진다. 테스트 케이스는 최대 100이다.

각 테스트 케이스의 첫째 줄에는 해빈이가 가진 의상의 수 n(0 ≤ n ≤ 30)이 주어진다.
다음 n개에는 해빈이가 가진 의상의 이름과 의상의 종류가 공백으로 구분되어 주어진다. 같은 종류의 의상은 하나만 입을 수 있다.
모든 문자열은 1이상 20이하의 알파벳 소문자로 이루어져있으며 같은 이름을 가진 의상은 존재하지 않는다.

출력
각 테스트 케이스에 대해 해빈이가 알몸이 아닌 상태로 의상을 입을 수 있는 경우를 출력하시오.

예제 입력 1 
2
3
hat headgear
sunglasses eyewear
turban headgear
3
mask face
sunglasses face
makeup face
예제 출력 1 
5
3
*/

// 풀이
import java.util.*;
 
public class Main {
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();	//전체 테스트 케이스 수
 
		for(int i=0; i<T; i++) {
			HashMap<String, Integer> hm = new HashMap<>();	//매번 다른 해쉬맵을 써준다.
			int N = sc.nextInt(); // 테스트에서 입력받을 옷의 개수이다.
      // 옷을 입력받는다. 다만 종류에 따라 값을 출력할 예정이라 cloth는 필요하지 않을 것이다.
			String cloth[] = new String[N];
      // 옷의 종류이다. 해빈이는 종류별로 입을 것이기 때문에 kind를 사용한다.
			String kind[] = new String[N];
			
      // 해당 옷을 입력받는다.
			for(int j=0; j<N; j++) {
				cloth[j] = sc.next();	
				kind[j] = sc.next();	
			}
			
      // 종류의 수를 구한다. ex) headgear의 개수, eyewear의 개수,face의 개수 등...
			for(String j : kind)
				hm.put(j, hm.getOrDefault(j, 0) + 1);
				
      // 정답을 넣어준다.
      // 참고로 정답은 입을 수 있는 종류를 구해서 ex)3개의 headgear라면 (1번, 2번, 3번, 안입기)총 4가지 경우가 존재한다.
      // 즉 입을 수 있는 합은 (종류+1)를 다 곱해주면 될 것이다.
			int result = 1;
 
      // 모든 경우를 구해서 정답을 구해 준다.
			for (int val : hm.values()) {
				result *= (val + 1);
			}
      // 전부 안입는 경우는 (안입기) * (안입기) * (안입기) .... 무조건 1이 나온다.
      // 전부 안입는 상태를 제외하려면 위의 result에서 1을 뺴주면 된다.
			System.out.println(result - 1);		

		}
			
	}
 
}
