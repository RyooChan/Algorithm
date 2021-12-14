/*
수 찾기 성공분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	87664	27528	18006	30.463%
문제
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

출력
M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.

예제 입력 1 
5
4 1 5 2 3
5
1 3 7 9 5
예제 출력 1 
1
1
0
0
1
*/

// 풀이
import java.util.*;

public class Main{
    public static int [] A ;
    
    
     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        
        // 기본적인 이분 탐색 문제이다.
        // 하나씩 재면 너무 오래 걸리므로, 순서대로 배열한 후 이를 원하는 숫자가 나타날 때 까지 반으로 갈라서 세면 된다. 예를 들어 1 2 3 4 5 6 7 -> 5를 찾으려 하면 가운데 값인 4를 기준으로 하나씩 확인하면 될 것이다.
        
        // 처음 값을 입력받는다.
        int input1 = sc.nextInt();
        A = new int [input1];
        for ( int i=0; i<input1; i++ )
        {
            A[i] = sc.nextInt();
        }
        
        // 확인할 다음 값들을 입력받는다.
        int input2 = sc.nextInt();
        int ans[] = new int[input2];
        
        // 값을 확인할 check이다.
        int check;
        
        // 배열을 순서대로 정렬시킨다.
        Arrays.sort(A);
        
        // 모든 input들에 대해 검사한다.
        for (int i = 0 ; i < input2 ; i++)
        {
            check = sc.nextInt();
            // 검사하고 바로 출력하면 된다.
            System.out.println( BS(0,A.length, check) );
        }
     }
     

     public static int BS( int first, int last, int input )
     {
          // 중간값을 구한다. 원하는 숫자들의 절반
         int half = ( first + last )/2;
         
         // 끝까지 가서 없으면 0을 return한다. -> 값이 없음
         if (half >= last)
             return 0;
             
         // 가운데 값이 원하는 값과 같으면 존재한다 -> 1 return
         if(A[half] == input)
         {
             return 1;
         }else if (A[half] < input)     // 그보다 작으면 현재위치~마지막까지 다시 진행
         {
             return BS(half+1, last, input);
         }else {                        // 그보다 크면 맨앞~현재위치까지 다시 
             return BS(first, half, input);
         }
     }
}
