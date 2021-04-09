/*
바이러스 출처분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	59897	27808	19142	44.841%
문제
신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.

예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다. 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.



어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다. 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.

출력
1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.

예제 입력 1 
7
6
1 2
2 3
1 5
5 2
5 6
4 7
예제 출력 1 
4
*/

// 풀이
import java.util.*;
public class Main {
	
	public static void main(String[] args) {
    // 바이러스에 걸린 컴퓨터에 DFS를 실행할 stack warm을 선언한다.
		Stack<Integer> warm = new Stack<>();
    // 이미 들어간 값들을 확인하기 위한 check이다.
		ArrayList<Integer> check = new ArrayList<>();
    // 답을 기입할 cnt이다.
		int cnt = 0;
		
        Scanner sc = new Scanner(System.in);
        
        // -----입력단-------------
        int M = sc.nextInt();
        int N = sc.nextInt();
        int virus[][] = new int[N][2];
        boolean exist = false;
        for(int i=0; i<N; i++) {
        	virus[i][0] = sc.nextInt();
    		  virus[i][1] = sc.nextInt();
        }
        // -------------------------
        
        // 순서대로 넣을 수 있도록 sort해 준다.(안해도 괜찮을듯)
        Arrays.sort(virus, Comparator.comparingInt(o1 -> o1[1]));  
        
        // 1번 컴퓨터가 감염되었다.
        warm.add(1);
        
        // 더이상 1번컴퓨터와 연관된 컴퓨터가 없는 경우 stack이 비게 되고, 해당 경우가 마지막이다.
        while(!warm.isEmpty()) {
          // 현재 감염된 컴퓨터를 가져온다.
        	int now = warm.pop();
          
          // 전체 길이에서 현재 감염된 것과 연관된 컴퓨터를 stack에 담아 줄 것이다.
        	for(int i=0; i<virus.length; i++) {
              // 이미 감염된 컴퓨터인지 확인하기 위해 감염된 컴퓨터를 다시 조회하는 경우 exist는 true, 아닌 경우 false로 했다.
            	exist = false;
              
            // 현재 감염된 컴퓨터와 연결된 무언가가 있는 경우
        		if(virus[i][0] == now) {
              // 혹시 그 연결된 컴퓨터가 이미 감염되었을 경우 exist를 true로 만든다.
        			for(int j=0; j<check.size(); j++)
        				if(check.get(j) == virus[i][1]) {
        					exist = true;
        					break;
        				}
              // 그렇게 해서 exist가 false인 경우 아직 감염되지 않은 컴퓨터이다.
        			if(!exist) {
                  // 컴퓨터를 감염시키고
            			warm.add(virus[i][1]);
                  // 감염되었다고 표시한다.
            			check.add(virus[i][1]);
                  // 그리고 다시 확인하지 않기 위해 초기화시켜준다.
            			virus[i][0] = 0;
            			virus[i][1] = 0;
                  // 감염된 컴퓨터가 1개 늘었다.
            			cnt++;
        			}
        		}
        		else if(virus[i][1] == now) { // 컴퓨터는 양쪽으로 연결되어 있고 뒷단이 감염된 경우도 똑같이 시도해 준다.
        			for(int j=0; j<check.size(); j++)
        				if(check.get(j) == virus[i][0]) {
        					exist = true;
        					break;
        				}
        			if(!exist) {
            			warm.add(virus[i][0]);
            			check.add(virus[i][0]);
            			virus[i][0] = 0;
            			virus[i][1] = 0;
            			cnt++;
        			}
        		}
        	}
        }
        
        System.out.println(cnt);
        
	}
	
	
}

