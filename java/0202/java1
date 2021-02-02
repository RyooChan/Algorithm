/*
나누어 떨어지는 숫자 배열
문제 설명
array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

제한사항
arr은 자연수를 담은 배열입니다.
정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
divisor는 자연수입니다.
array는 길이 1 이상인 배열입니다.
입출력 예
arr	divisor	return
[5, 9, 7, 10]	5	[5, 10]
[2, 36, 1, 3]	1	[1, 2, 3, 36]
[3,2,6]	10	[-1]
입출력 예 설명
입출력 예#1
arr의 원소 중 5로 나누어 떨어지는 원소는 5와 10입니다. 따라서 [5, 10]을 리턴합니다.

입출력 예#2
arr의 모든 원소는 1으로 나누어 떨어집니다. 원소를 오름차순으로 정렬해 [1, 2, 3, 36]을 리턴합니다.

입출력 예#3
3, 2, 6은 10으로 나누어 떨어지지 않습니다. 나누어 떨어지는 원소가 없으므로 [-1]을 리턴합니다.
*/

// 풀이
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        // divisor로 나뉜 값이 저장될 arraylist를 선언한다.
        ArrayList<Integer> ans = new ArrayList<>();
        
        // 전체 길이동안 나머지가 없는 값(나누었을때 딱 나뉘어 떨어지는 값)들을 저장한다.
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] % divisor == 0)
                ans.add(arr[i]);
        }
        
        // arr의 모든 원소가 나뉘지 않으면 -1이 저장된다.
        if(ans.isEmpty())
            ans.add(-1);
        
        // answer의 크기는 위에까지의 process가 진행된 ans값의 크기를 선언한다.
        int[] answer = new int[ans.size()];
        
        // 이후 전체 값들을 저장하면 완료된다.
        for(int i=0; i<ans.size(); i++)
            answer[i] = ans.get(i);
        
        Arrays.sort(answer);
            
            
        
        return answer;
    }
}
