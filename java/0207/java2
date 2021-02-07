/*
다리를 지나는 트럭
문제 설명
트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.

예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
0	[]	[]	[7,4,5,6]
1~2	[]	[7]	[4,5,6]
3	[7]	[4]	[5,6]
4	[7]	[4,5]	[6]
5	[7,4]	[5]	[6]
6~7	[7,4,5]	[6]	[]
8	[7,4,5,6]	[]	[]
따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.

solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

제한 조건
bridge_length는 1 이상 10,000 이하입니다.
weight는 1 이상 10,000 이하입니다.
truck_weights의 길이는 1 이상 10,000 이하입니다.
모든 트럭의 무게는 1 이상 weight 이하입니다.
입출력 예
bridge_length	weight	truck_weights	return
2	10	[7,4,5,6]	8
100	100	[10]	101
100	100	[10,10,10,10,10,10,10,10,10,10]	110
출처

※ 공지 - 2020년 4월 06일 테스트케이스가 추가되었습니다.
*/

// 풀이
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> waiting = new LinkedList<>();
        Queue<Integer> moving = new LinkedList<>();
        int answer = 0;
        
        // time이 0이 되면 나가는 것으로 판단하기 때문에 초기값은 0이 아닌 음수값, -1로 설정.
        int[] time = new int[truck_weights.length];
        for(int i=0; i<truck_weights.length; i++)
            time[i] = -1;
        
        int location = 0;
        int now = 0;
        int pressure = 0;
        
        for(int i=0; i<truck_weights.length; i++)
            waiting.add(truck_weights[i]);
        
        while(!waiting.isEmpty() || !moving.isEmpty())
        {
            // while문은 1초마다 모든 process를 진행하도록 한다.
            
            
            // time은 트럭이 다리를 지나갈 때 까지 걸리는 시간이므로 0이 될 때까지 빼준다.
            // 시간이 빠지는 함수이므로 맨 위에 있어야 한다.
            for(int i=0; i<truck_weights.length; i++)
                if(time[i] > 0)
                    time[i]--;
            
            // 다리를 다 지나갔다면
            // 다리에는 한번에 하나의 트럭이 올라가므로 now는 가장 위에 값을 판단하고 다음으로 넘어가면 된다. while문은 1초에 한번씩 진행하기 때문.
            if(now < truck_weights.length)
            if(time[now]==0)
            {
                // 다 지나갔으므로 무게를 빼준다.
                pressure -= moving.peek();
                // time은 최초에 선언된 -1로 간다.
                time[now] = -1;
                // 다 지나갔으므로 queue에서 삭제된다.
                moving.remove();
                // 다음 배열을 확인한다.
                now++;
            }
            
            // 현재 무게 + 대기중인 무게의 값이 최대 무게보다 가볍다면
            if(!waiting.isEmpty())
            if(pressure + waiting.peek() <= weight)
            {
                // 트럭이 지나가게 되어 moving으로 waiting에서 이동.
                moving.offer(waiting.peek());
                // 무게에는 지나가게 되는 트럭의 무게가 더해진다.
                pressure += waiting.peek();
                // 움직이게 되어 기존 트럭이 삭제된다.
                waiting.remove();
                // 해당 트럭은 다리의 길이만큼 이동해야 한다.
                time[location] = bridge_length;
                // queue의 가장 위에 있는 요소는 truck_weight 배열의 해당 location
                location++;
            }
            
            answer++;
        }
        
        
        
        return answer;
    }
}
