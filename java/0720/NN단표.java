/*
NN단표
이전다음
문제
알랩이는 구구단표처럼 NN단표를 만들었다고 한다.

NN단표는 2차원 배열의 모양으로 곱셈 1단부터 N단까지의 값들을 적어놓은 형태이다.

NN단표의 배열을 A라고 했을 때, 배열의 들어가는 수 A[i][j]=i*j이다.(즉, 4행 7열에는 28, 7행 5열에는 35가 들어가 있다.)

알랩이는 N단까지 나온 숫자들 중에서 K번째로 작은 수를 찾고 싶어한다.

이때, 중복되는 여러 수들을 고려한다. 즉 N*N개의 모든 수들 중에서 K번째 수를 구하는 것이다.  

입력
첫째 줄에 배열의 크기 N이 주어진다. N은 100,000보다 작거나 같은 자연수이다. 둘째 줄에 K가 주어진다. K는 N*N보다 작거나 같은 자연수이다.  

출력
K번째 원소를 출력한다.

 

예제 입력
copy3
7
예제 출력
copy6
*/

// 풀이
import java.util.Scanner;
public class Main{
  public static int N;
  public static long K;
  public static long ans;
    public static void main(String[] args){

      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      K = sc.nextLong();
      ans = N*N;    // 최대값으로 세트
      
      bs(1, N*N);   // 바이너리 서치
      System.out.println(ans);

    }
    public static void bs(long first, long last){
      if(first > last) return;  // first가 last보다 크다는건 ans를 구하기 위한 이진탐색이 끝났다는 것이다. 그러므로 나가면 된다.
      long sum = 0;   // 값을 구하려면 전체 NN단표에 대해 1단, 2단, 3단...해서 현재 숫자보다 작거나 같은 개수가 몇개인지 구해주면 된다.
      long mid = (first + last) / 2;  // 현재 숫자 mid는 first와 last의 범위 내에서 구하면 된다.
      for(int i=0; i<N; i++){ // 각 단에 대해
        long cnt = mid / (1+i);   // 단에서 mid보다 작거나 같은 개수 cnt를 구한다. mid를 단으로 나눠주면 구할 수 있다.
        if(cnt > N) cnt = N;    // 나눈 값이 N보다 클수는 없다. 크면 N으로 만듬.
        sum += cnt;   // 그 값을 계속 더한다.
      }
      
      if( sum < K )bs(mid+1, last); // 그래서 더한 수가 구하려는 숫자 K보다 작으면 지금 mid보다 커야 한다. 그 다음부터 다시 bs시작
      else{   // 더 크면 넘어섰기 때문에 지금 크기보다 작아야 한다. 아래 범위 bs시작
        ans = Math.min(ans, mid); // ans는 현재값과 현재 ans중 작은 값이다. <- sum이 K보다 크거나 같기 때문에 mid의 값은 어느정도인지 모르는 상태이기 때문이다.
        bs(first, mid-1);   // 이후 다시 bs시행
      }
      
    }
}
