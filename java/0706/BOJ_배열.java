/*
문제
N이 주어질 때, 다음과 같은 프로그램을 작성해보자.  

입력
첫째 줄에 자연수 N이 주어진다.(1<=N<=100)

 

출력
예시를 참고하여 작성하자.

 

예제 입력
copy3 
예제 출력
copy1 2 4
3 5
6 
 

예제 입력
copy5
예제 출력
copy1 2 4 7 11
3 5 8 12 
6 9 13 
10 14
15 
*/

// 풀이
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int num[][] = new int[N][N];
      int X = 1;
      int Y = 1;
      int sum = 0;
      for(int i=0; i<N; i++){
        X = 0;
        sum = 0;
        for(int j=0; j<N-i; j++){
          
          sum = X + Y;
          num[i][j] = sum;
          X += (i+j+1);
        }
        Y += (i+2);
      }
      
      for(int i=0; i<N; i++){
        for(int j=0; j<N-i; j++)
          System.out.printf("%d ", num[i][j]);
        System.out.println();
      }
      
      
    }
}
