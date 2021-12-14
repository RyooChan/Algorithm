/*
전화번호 목록
문제 설명
전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

구조대 : 119
박준영 : 97 674 223
지영석 : 11 9552 4421
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

제한 사항
phone_book의 길이는 1 이상 1,000,000 이하입니다.
각 전화번호의 길이는 1 이상 20 이하입니다.
입출력 예제
phone_book	return
[119, 97674223, 1195524421]	false
[123,456,789]	true
[12,123,1235,567,88]	false
입출력 예 설명
입출력 예 #1
앞에서 설명한 예와 같습니다.

입출력 예 #2
한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.

입출력 예 #3
첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.
*/

// 처음 hashmap을 통해 풀어본 알고리즘인데, 효율성에서 낮은 점수가 나와 hash를 사용하지 않고 풀었음.
// 풀이
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<Integer, String> numbers = new HashMap<Integer, String>();      
        
        for(int i=1; i<phone_book.length; i++)
            phone_book[i] = phone_book[i].substring(0, phone_book[0].length());
        
        for(int i=1; i<phone_book.length; i++)
            numbers.put(i, phone_book[i]);
        
        for(int i : numbers.keySet())
            if(numbers.containsValue(phone_book[0]))
                answer = false;
        
        
        return answer;
    }
}



// 다음으로 hash없이 startwith를 통해 풀었는데, 여기서 Arrays.sort를 사용하는 이유는 모르겠음.
// 풀이

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // phone_book을 오름차순으로 정렬하는데, 이거를 사용하는 이유를 모르겠다.
        Arrays.sort(phone_book);
        
        // 처음 문자열로 시작하는 전화번호를 찾는 방식이다.
        for(int i=1; i<phone_book.length; i++){
            if(phone_book[i].startsWith(phone_book[0]))
                answer = false;
        }
        
        return answer;
    }
}
