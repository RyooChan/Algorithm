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

// 다른 풀이방법


// 풀이
import java.util.Scanner;
public class Main{
    public static void main(String[] args){

       // Please Enter Your Code Here

       Scanner sc = new Scanner(System.in);
       
       int N = sc.nextInt();
       int S = sc.nextInt();
       
       for(int i = 1; i <= N; i++){
         for(int j = i; j < N; j++){
           System.out.print(" ");
         }
         
         if(i%2 == 0){ // 짝수 행일때 
           for(int j = 1; j <= (i-1)*2+1; j++){
            S++;
            if(S%10 == 0){
              S = 1;
            }
            System.out.print(S%10);
           }
         }
         else if(i == 1){ // 시작
          
          System.out.print(S);
         }
         else if(i%2 == 1){ // 홀수 행일때
            int count = 0;
            int temp = 0;
           for(int j = 1; j <= (i-1)*2+1; j++){
             count++;
           }
           S = S + count;
           while( S >= 10 ){    // 이렇게 풀면 된다. 10 11 12 13....20 21 22 23..... -> (1 2 3 4.....2 3 4 5.....)이렇게 하면 나옴.
             S = S/10 + S%10;
           }
           
           temp = S;
           if(S%10 == 0) {
              S++;
           }
           for(int j= 1; j <= (i-1)*2+1; j++){
              if(S%10 == 0){
                S = 9;
              }
              System.out.print(S%10);
              S--;
           }
           S = temp;
         }
         System.out.println();
       }
       
    }
}
