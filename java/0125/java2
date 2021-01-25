/*
문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
입출력 예
answers	return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
입출력 예 설명
입출력 예 #1

수포자 1은 모든 문제를 맞혔습니다.
수포자 2는 모든 문제를 틀렸습니다.
수포자 3은 모든 문제를 틀렸습니다.
따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

입출력 예 #2

모든 사람이 2문제씩을 맞췄습니다.
*/

// 풀이
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        // 혼자 할때는 시간초과가 발생해서 개인별 정답 맞추는 부분 이중for문을 없애기 위해 질문하기 이용.
        
        int[] answer = {};
        // 학생 1, 2, 3의 정답 패턴을 적어둠.
        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};
        // 학생별 맞춘 문제 수.
        int answer1=0, answer2 =0, answer3 =0;
        
        // 본래 이중 for문을 통해 학생.length 만큼 진행하였는데, length만큼 i의 나머지를 구하면 i가 몇이 나오든 관계없이 구할 수 있다는 것을 배움.
        // 각 문제를 맞출 때 마다 해당 학생의 정답수가 증가한다.
        for(int i =0; i<answers.length; i++){
            if(person1[i%person1.length] == answers[i]) answer1++;
            if(person2[i%person2.length] == answers[i]) answer2++;
            if(person3[i%person3.length] == answers[i]) answer3++;
        }
        
        // 학생의 정답 수 중 최대값을 저장시킨다.
        int max = Math.max(Math.max(answer1, answer2),answer3);
        // ArrayList를 만들어 가장 많은 정답을 맞춘 학생의 번호를 저장시킨다. 복수의 학생이 같은 수를 맞추었을 경우 모두 저장시킨다.
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(max==answer1) list.add(1);
        if(max==answer2) list.add(2);
        if(max==answer3) list.add(3);
        
        answer = new int[list.size()];
        
        // answer은 list의 값들을 모두 넣도록 설정한다.
        for(int i =0; i<answer.length; i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}
