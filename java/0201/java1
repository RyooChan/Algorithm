/*
2016년
문제 설명
2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT

입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 TUE를 반환하세요.

제한 조건
2016년은 윤년입니다.
2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
입출력 예
a	b	result
5	24	TUE
*/

// 풀이
class Solution {
    public String solution(int a, int b) {
        String answer = "";
        // 12월 윤년 포함 저장.
        int month[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 1월 1일이 금요일이기 때문에 목요일부터 시작하는 요일을 생성.
        String yoil[] = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int days = 0;
        
        // 1월부터 달의 날짜를 더해준다.
        for(int i=0; i<a-1; i++)
            days += month[i];
        
        // 일의 날짜를 더한다.
        days += b;
        
        // 7일로 나누어 요일을 구할수 있게 한다.
        days %= 7;

        // 정답은 이에 해당하는 요일이 나온다.
        answer += yoil[days];
        
        return answer;
    }
}


