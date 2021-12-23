/*
문제
N과 시작 숫자 S가 주어지면 숫자 피라미드를 만드는 프로그램을 작성하시오.
예를 들어, N이 5이고 S가 3 이라면, 그 숫자 피라미드는 다음과 같다.

copy    3
   456
  21987
 3456789
987654321
시작 숫자 S는 꼭대기부터 1씩 증가한다.
시작 행의 번호가 1번이라고 했을때, 짝수번째 행은 왼쪽에서 오른쪽으로 1씩 증가하도록 적고, 홀수번째 행은 거꾸로 적는다.
숫자가 만약 10이 될 경우, 1로 바꾸고 다시 증가한다.  
입력
입력의 첫 번째 줄에 N과 시작 숫자 S가 주어진다. ( 1≤N≤100, 1 ≤S≤ 9)

 

출력
첫 번째 줄부터 숫자 피라미드를 출력한다. (각 줄에 존재하는 공백의 개수와 숫자의 개수를 정확하게 확인해주시바랍니다.)

 

예제 입력
copy5 3
예제 출력
copy    3
   456
  21987
 3456789
987654321
*/

// 풀이
// 배열 없이 queue stack연습할때 좋을듯싶다.
import java.util.*;

public class Main{
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);

       int N = sc.nextInt();
       int S = sc.nextInt();
       int cnt = S-1;;
       Queue<Integer> even = new LinkedList<>();
       Stack<Integer> odd  = new Stack<>();
       
       for(int i=1; i<N+1; i++){
         for(int k=0; k<N-i; k++) System.out.print(" "); //처음에 띄기
         
         if(i%2 == 1){ // 1 3 5 7번째 줄이면 왼쪽에서 오른쪽 -> 그러면 선입후출로 하면 됨.
           for(int j=0; j<i*2-1; j++){
             cnt++;
             if(cnt >= 10) cnt -= 9;
             odd.push(cnt);
           }
           while(!odd.isEmpty()) System.out.print(odd.pop());
         }
         else{      // 2 4 6 8...이면 오른쪽에서 왼쪽 -> 그러면 선입선출로 하면 됨.
           for(int j=0; j<i*2-1; j++){
             cnt++;
             if(cnt >= 10) cnt -= 9;
             even.add(cnt);
           }
           while(!even.isEmpty()) System.out.print(even.poll());
         }
         System.out.println();
       }

    }
}
// 아이디어를 생각하는건 어려웠는데 생각하고 나면 구현이 간단히 나왔다. 처음에는 값을 배열에 저장하였는데, 그러면 식이 굉장히 복잡해짐
