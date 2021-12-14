/*
문제 설명
정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers의 길이는 2 이상 100 이하입니다.
numbers의 모든 수는 0 이상 100 이하입니다.
입출력 예
numbers	result
[2,1,3,4,1]	[2,3,4,5,6,7]
[5,0,2,7]	[2,5,7,9,12]
입출력 예 설명
입출력 예 #1

2 = 1 + 1 입니다. (1이 numbers에 두 개 있습니다.)
3 = 2 + 1 입니다.
4 = 1 + 3 입니다.
5 = 1 + 4 = 2 + 3 입니다.
6 = 2 + 4 입니다.
7 = 3 + 4 입니다.
따라서 [2,3,4,5,6,7] 을 return 해야 합니다.
입출력 예 #2

2 = 0 + 2 입니다.
5 = 5 + 0 입니다.
7 = 0 + 7 = 5 + 2 입니다.
9 = 2 + 7 입니다.
12 = 5 + 7 입니다.
따라서 [2,5,7,9,12] 를 return 해야 합니다.
*/

// 풀이
import java.util.Arrays;
import java.util.ArrayList;
import java.util.TreeSet;

class Solution {
    static public int[] solution(int[] numbers) {
        //TreeSet을 사용하면 중복제거 + 오름차순을 동시에 할 수 있다.
        //처음으로 모든 함수 요소의 합을 저장할 ArrayList sum을 만든다.
        ArrayList<Integer> sum = new ArrayList<Integer>();

        //0-1234...., 1-234...., 2-34....순서로 모든 배열을 더한다.
        for (int i = 0; i < numbers.length - 1; i++) 
        {
            for (int j = i + 1; j < numbers.length; j++) 
                sum.add(numbers[i] + numbers[j]);
        }

        //TreeSet을 사용하여 sum의 값을 중복제거 + 오름차순 정렬한다.
        TreeSet<Integer> asc = new TreeSet<Integer>(sum);
        //TreeSet을 통해 만든 값을 다시 ArrayList로 정리한다.
        ArrayList<Integer> last = new ArrayList<Integer>(asc);
        
        //결과값에 최종 정답인 last의 값을 저장시킨다.
        int[] answer = new int[last.size()];

        for (int i = 0; i < last.size(); i++) {
            answer[i] = last.get(i);
        }

        return answer;
    }
}
