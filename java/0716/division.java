/*
division
이전다음
문제
임의의 자연수는 그보다 작은 자연수들의 합으로 표현될 수 있다. 예를 들어 4의 경우,

4
= 3+1
= 2+2
= 2+1+1
= 1+1+1+1

위와 같은 방법으로 표현 될 수 있다. 이 때 , 숫자의 구성이 같으면서 그 순서만이 다른 경우는 같은 경우로 생각하는데, 예를 들어 다음 세 가지 경우는 모두 같은 경우이다.

2 + 1 + 1, 1 + 2 + 1 , 1 + 1 + 2

자연수 n을 입력 받아 이를 n보다 작은 자연수들의 합으로 나타내는 방법을 모두 출력하는 프로그램을 재귀 호출을 사용하여 작성하시오.

 

입력
첫 줄에 2 이상 20 이하의 자연수 n이 주어진다.

 

출력
첫째 줄부터 모든 방법을 한 줄에 하나씩 출력한다. 하나의 식 안에는 큰 숫자가 앞으로 오도록 하고, 전체적으로는 앞의 숫자가 큰 식이 먼저 출력되도록 한다. 숫자와 더하기 사이에는 공백이 없다. 그리고 마지막 줄에는 나누어진 자연수의 개수를 출력한다.

 

예제 입력
copy5
예제 출력
copy4+1
3+2
3+1+1
2+2+1
2+1+1+1
1+1+1+1+1
6
*/

// 풀이

import java.util.Scanner;

public class Main{
    public static int N;
    public static int cnt = 0;
    public static String str = "";
    
    public static void main(String[] args){
  
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      
      division(N-1, 0);
      System.out.println(cnt);
    }
    public static void division(int num, int made){
      if( made == N ){  // 만들어낸 숫자가 처음 받은 목표N과 같으면 
        cnt++;  // 만들 수 있는 숫자이다.
        System.out.println(str.substring(0, str.length()-1)); // 아래를 보면 알겠지만 마지막에 +가 생기므로 그걸 빼고 출력 
        return;
      }
      for(int i=num; i>0; i--){ // 목표 바로 전부터 시작하는데 큰 수부터 하나씩 확인한다.
        if(made+i <= N){  // 지금 만들 숫자가 목표보다 작거나 같으면 
          int iLength = (int)(Math.log10(i)+1)+1; // 만든 숫자의 자리수 + 1dmf 구한다.
          str += Integer.toString(i); // 출력 문장의 숫자
          str += "+"; // +가 있어야 하므로 더한다. <= 이러면 마지막에 무조건 +가 들어가겠지.
          made += i;  // 되니까 만들 숫자는 더해줄 i로 간다.
          division(i, made);  // 재귀 수행.
          made -= i;  // 재귀 수행했으니까 다시 돌아와서 다음꺼 한다.
            str = str.substring(0, str.length()-iLength); // 그 자리수로 만든 숫자만큼 뺴주면 된다. <- 숫자랑 + 삭제
        }
      }
    }
}
