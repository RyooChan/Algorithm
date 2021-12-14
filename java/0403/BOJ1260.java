/*
1260번
제출
맞은 사람
숏코딩
재채점
채점 현황
내 제출
강의
질문 검색
DFS와 BFS 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	126078	44785	25753	33.728%
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

예제 입력 1 
4 5 1
1 2
1 3
1 4
2 4
3 4
예제 출력 1 
1 2 4 3
1 2 3 4
예제 입력 2 
5 5 3
5 4
5 2
1 2
3 4
3 1
예제 출력 2 
3 1 2 5 4
3 1 4 2 5
예제 입력 3 
1000 1 1000
999 1000
예제 출력 3 
1000 999
1000 999
*/


// 풀이
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {	
	public static void main(String[] args) throws Exception  {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        // 이중배열을 통해 / 2-1연결은 arr[2][1], arr[1][2]를 1 / 2-4연결은 arr[2][4], arr[4][2]를 1로 할 것이다.
        int DFS[][] = new int[N+1][N+1];
        int BFS[][] = new int[N+1][N+1];
        // DFS는 stack, BFS는 queue로 해결하려 한다.
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        // 각각의 정답은 DFS, BFS를 따로 담는다.
        int[] ansD = new int[N];
        int[] ansF = new int[N];
        int cnt = 0;
        int check;
        boolean exist = true;
		
		// 입력, DFS와 BFS 모두 정점이 양방향이므로 뒤집어가며 1로 만든다.
		for(int i=0; i<M; i++)
		{
            st= new StringTokenizer(br.readLine());
            int first  = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            DFS[first][second] = DFS[second][first] = 1;
            BFS[first][second] = BFS[second][first] = 1;
		}
		
		// 여기서부터 DFS이다.
        // 시작 노드 V를 stack에 넣어 준다.
		stack.push(V);
        
		// process는 이 스택에 값이 전부 나갈 때 까지 진행된다.
		while(stack.size() != 0)
		{
            // 다음 노드를 넣기 위한 체크값 check를 stack에서 값을 빼서 선언한다.
			check = stack.pop();
            // 이미 존재하는 값이면 false, 넣어도 되면 true.
			exist = true;
            // 현재까지 답에 값이 있으면 false를 통해 값을 넣을 수 없게 한다.
			for(int j=0; j<ansD.length; j++)
				if(ansD[j] == check)
				{
					exist = false;
					break;
				}
			
            // 넣어도 되면 넣어준다. 이 cnt는 나중에 전체 ans의 값의 출력에 사용된다.
			if(exist)
				ansD[cnt++] = check;
			
            // 실질적인 DFS프로세스이다.
            // stack은 선입후출법이기 때문에 먼저 들어간 값이 나중에 나온다. 제한사항에 작은 값이 먼저 나와야 하므로 나중에 출력되어야 하는 큰 값을 먼저 넣어 준다.
			for(int i=N; i>=0; i--)
			{
                // 높은 값부터 내려가며 혹시 연결되어 있으면(1이면) 연결된 값을 넣어주고, 이미 찾은 값은 다시 사용해서는 안되므로 0으로 세트해 준다.
				if(DFS[check][i] == 1 || DFS[i][check] == 1)
				{
					stack.push(i);
					DFS[check][i] = DFS[i][check] = 0;
				}
			}
		}
		
	//----------BFS진행부분---------------------------------------------------------------	
		// queue로 사용한다. 마찬가지로 처음 정점을 넣어 준다.
        queue.add(V);
		cnt = 0;
		
        // 위와 동일한 process이다. 정답에 값이 있으면 넣지 않고, 없으면 넣는다.
		while(queue.size() != 0)
		{
			check = queue.poll();
			exist = true;
			for(int j=0; j<ansF.length; j++)
				if(ansF[j] == check)
				{
					exist = false;
					break;
				}
				
			if(exist)
				ansF[cnt++] = check;
			
            // queue는 선입선출법이기 때문에 0부터 진행한다. 나머지는 위와 유사하다.
			for(int i=0; i<N+1; i++)
			{
				if(BFS[check][i] == 1 || BFS[i][check] == 1)
				{
					queue.add(i);
					BFS[check][i] = BFS[i][check] = 0;
				}
			}
		}
		

        for(int i=0; i<cnt; i++)
        	System.out.printf("%d ", ansD[i]);
        
        System.out.println();
        
        for(int i=0; i<cnt; i++)
        	System.out.printf("%d ", ansF[i]);
	}

}
	
