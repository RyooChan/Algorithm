/*
직각삼각형 성공출처다국어분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	26575	14099	12759	53.314%
문제
과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.

입력
입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다. 각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.

출력
각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.

예제 입력 1 
6 8 10
25 52 60
5 12 13
0 0 0
예제 출력 1 
right
wrong
right
*/

// 풀이
import java.util.*;

public class Main{
     public static void main(String []args){
    	 int A;
    	 int B;
    	 int C;
    	 ArrayList<String> ans = new ArrayList<>();
    	 
    	 Scanner sc = new Scanner(System.in);
    	 A = sc.nextInt();
    	 B = sc.nextInt();
    	 C = sc.nextInt();
    	 while(A!=0 && B!=0 && C!=0) {
             int sorter[] = new int[3];
             sorter[0] = A;
             sorter[1] = B;
             sorter[2] = C;
             Arrays.sort(sorter);
             A = sorter[0];
             B = sorter[1];
             C = sorter[2];
             
    		 if(A*A + B*B == C*C) ans.add("right");
    		 else ans.add("wrong");
    		 A = sc.nextInt();
    		 B = sc.nextInt();
    		 C = sc.nextInt();
    	 }
    	 for(String i : ans)System.out.println(i);
    	 
     }
}
