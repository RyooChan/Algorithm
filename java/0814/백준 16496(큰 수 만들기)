/*
큰 수 만들기 성공출처
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	1526	520	395	34.468%
문제
음이 아닌 정수가 N개 들어있는 리스트가 주어졌을 때, 리스트에 포함된 수를 나열하여 만들 수 있는 가장 큰 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄에는 리스트에 포함된 수가 주어진다. 수는 공백으로 구분되어져 있고, 1,000,000,000보다 작거나 같은 음이 아닌 정수 이다. 0을 제외한 나머지 수는 0으로 시작하지 않으며, 0이 주어지는 경우 0 하나가 주어진다.

출력
리스트에 포함된 수를 나열하여 만들 수 있는 가장 큰 수를 출력한다. 수는 0으로 시작하면 안되며, 0이 정답인 경우 0 하나를 출력해야 한다.

예제 입력 1 
5
3 30 34 5 9
예제 출력 1 
9534330
예제 입력 2 
5
0 0 0 0 1
예제 출력 2 
10000
*/

// 풀이
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String ans = "";
		ArrayList<String> list = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // 값을 읽어온다.
		
		String input = br.readLine();
		String num[] = input.split(" ");    // 값 만들어주기
		
		Arrays.sort(num,Collections.reverseOrder());    // 문자를 sort하면 사전순으로 나열됨.(사전순으로 나열하면 31 < 4이다) reverseOrder을 사용하여 큰 수부터 내림차순으로 정렬한다.
		for(String temp : num) list.add(temp);  // 그렇게 해서 나누어진 문자들을 ArrayList에 넣는다. 그 이유는 문자를 변경하는 경우가 있기 때문이다.
		
		int digitNow;     // 현재 숫자의 맨 앞 자리수 digitNow
		int digitBefore = -1;   // 이전 숫자의 맨 앞 자리수 digitBefore <- 절대 맨 앞 자리수가 -1이 될수 없으므로 시작점은 자리수가 바뀌고 시작함.
		int standard = 0;  // 위의 자리수가 바뀌는 경우를 기준으로 구할 필요가 있다.
		for(int i=0; i<N; i++) {
			digitNow = num[i].charAt(0)-'0';  // 현재 숫자 자리수 구함.
			if(digitNow!=digitBefore) {   // 이전 숫자 자리수와 현재 숫자 자리수가 다르면.
				standard = i;     // 그 바뀌어진 현재 숫자를 기준으로 구함.
			}
			for(int j=standard; j<i; j++) {   // 자리수는 9~0까지 있고, 이전 숫자와 자리수가 바뀌었으면 그 때부터 지금 구하는 숫자까지 비교해 준다. 참고로 0부터 해도 되는데 나는 그냥 효율성을 위해 이걸 썼다.
				if(num[j].startsWith(list.get(i))) {    // 앞에서 존재하는 숫자들 중 현재 숫자로 시작하는 것이 있다면 (ex 현재숫자 : 3 , 이전숫자 : 30 )
					String comp1 = list.get(i)+list.get(j);   // comp1은 그럼 330이 될것이다.
					String comp2 = list.get(j)+list.get(i);   // comp2는 303이다.
					if(Long.parseLong(comp1) > Long.parseLong(comp2)) {   // 그러면 현재숫자가 이전숫자보다 앞으로 가야한다. 위치를 바꾸어 준다.
						list.add(j, list.get(i));   // ArrayList를 사용하면 앞에다가 끼워넣을 수 있다.
						list.remove(i+1);           // 현재숫자 노드 삭제
						break;
					}
				}
			}
			digitBefore = digitNow;     // 지금 숫자 자리수를 이전에 저장.
		}
		
		for(String i : list) {      // ArrayList의 모든 숫자를 하나씩 빼가면서 결과 만들기.
			ans += i;
		}
		
		if(ans.startsWith("0") && ans.endsWith("0")) ans = "0";   // 여기서 2시간정도 쓴듯....00000 -> 0이다 중요하다.
		
		bw.write(ans+"\n");
		bw.flush();   //남아있는 데이터를 모두 출력시킴
		bw.close();   //스트림을 닫음
	}

}
