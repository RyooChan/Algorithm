/*

소수 구하기 성공
시간 제한   메모리 제한   제출   정답   맞은 사람   정답 비율
2 초   256 MB   111324   31046   21997   27.186%
문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

예제 입력 1 
3 16
예제 출력 1 
3
5
7
11 
13 

*/

 

// 풀이

import java.util.*;

 

public class Main {

   public static boolean[] prime;

   public static void main(String[] args) {

 

      Scanner sc = new Scanner(System.in);

      int M = sc.nextInt();

      int N = sc.nextInt();

      

      prime = new boolean[N + 1];

      get_prime();

            

      for(int i = M; i <= N; i++) {

         if(!prime[i]) System.out.println(i);

      }

   }

 

 

   public static void get_prime() {

      prime[0] = prime[1] = true;

      

      for(int i = 2; i <= Math.sqrt(prime.length); i++) {

         if(prime[i]) continue;

         for(int j = i * i; j < prime.length; j += i) {

            prime[j] = true;

         }

      }

   }

}
