/*
문제 설명
일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.

1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.
예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.

내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.

현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때, 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.

제한사항
현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
입출력 예
priorities	location	return
[2, 1, 3, 2]	2	1
[1, 1, 9, 1, 1, 1]	0	5
입출력 예 설명
예제 #1

문제에 나온 예와 같습니다.

예제 #2

6개의 문서(A, B, C, D, E, F)가 인쇄 대기목록에 있고 중요도가 1 1 9 1 1 1 이므로 C D E F A B 순으로 인쇄합니다.
*/

// 풀이
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // 프린트는 First in, First out 방식을 사용하기 때문에 queue를 활용한다.
        Queue<Integer> waiting = new LinkedList<>();
        
        // 먼저 queue waitng에 순서대로 값을 넣어준다.
        for(int i=0; i<priorities.length; i++)
            waiting.offer(priorities[i]);
        
        // 모든 기다리는 print가 완료되기 전까지 코드를 수행한다.
        while(!waiting.isEmpty())
        {
            // 더 중요한 프린트가 있을 경우 ture, 아닌 경우 false.
            boolean importance = false;
            
            // queue의 모든 값들과 현재 peek값을 비교하여 중요도가 높은 것이 있는 경우 ture로 설정한다.
            for(int i : waiting)
            {
                if(i>waiting.peek())
                    importance = true;
            }
            
            // 현재 값이 최우선이 아닌 경우
            if(importance)
            {
                // 현재 값을 rear로 보낸 후, 삭제한다.
                waiting.offer(waiting.peek());
                waiting.remove();
                // 그리고 현재 존재하는 위치가 알고 싶은 프린트 번호라면, 맨 뒤로 가기 때문에 현재 queue의 크기만큼 앞에 수행해야 할 작업이 존재한다.
                if(location==0)
                    location += waiting.size();
            }
            // 현재 값이 최우선인 경우.
            else
            {
                // 값을 빼내 준다.
                waiting.poll();
                // 그리고 그 값이 빠진 만큼 작업이 행해지기 때문에 answer을 더해준다.
                answer++;
                // 만약 지금 나간 값이 원하는 작업의 위치라면 while문을 나가면 된다.
                if(location == 0)
                    break;
            }
                
            // 매 작업이 행해질 때 마다  location의 위치는 한 칸씩 peek로 이동하게 된다.
            location--;
        }
        
        return answer;
    }
}
