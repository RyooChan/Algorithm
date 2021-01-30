/*
3진법 뒤집기
문제 설명
자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 1 이상 100,000,000 이하인 자연수입니다.
입출력 예
n	result
45	7
125	229
입출력 예 설명
입출력 예 #1

답을 도출하는 과정은 다음과 같습니다.
n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
45	1200	0021	7
따라서 7을 return 해야 합니다.
입출력 예 #2

답을 도출하는 과정은 다음과 같습니다.
n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
125	11122	22111	229
따라서 229를 return 해야 합니다.
*/

// 풀이
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String save = "";
        
        // 3진법으로 만들어서 저장한다.
        while(n!=0){
            save += n%3;
            n /= 3;
        }
        
        // 저장된것을 거꾸로 뒤집어서 계산한다. 그런데 charAt(0)부터 계산하면 같은 계산이 나온다.
        for(int i=0; i<save.length(); i++){
            answer += Integer.parseInt(save.charAt(i) + "");
            answer *= 3;
        }
        
        // 마지막 값을 구한뒤에도 answer에 3이 곱해져서 이를 다시 나누어준다.
        answer /= 3;
        
        return answer;
    }
}
