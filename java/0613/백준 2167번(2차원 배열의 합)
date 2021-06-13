/*
2차원 배열의 합 성공분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	17259	9911	7823	59.324%
문제
2차원 배열이 주어졌을 때 (i, j) 위치부터 (x, y) 위치까지에 저장되어 있는 수들의 합을 구하는 프로그램을 작성하시오. 배열의 (i, j) 위치는 i행 j열을 나타낸다.

입력
첫째 줄에 배열의 크기 N, M(1 ≤ N, M ≤ 300)이 주어진다. 다음 N개의 줄에는 M개의 정수로 배열이 주어진다. 배열에 포함되어 있는 수는 절댓값이 10,000보다 작거나 같은 정수이다. 그 다음 줄에는 합을 구할 부분의 개수 K(1 ≤ K ≤ 10,000)가 주어진다. 다음 K개의 줄에는 네 개의 정수로 i, j, x, y가 주어진다(i ≤ x, j ≤ y).

출력
K개의 줄에 순서대로 배열의 합을 출력한다. 배열의 합은 231-1보다 작거나 같다.

예제 입력 1 
2 3
1 2 4
8 16 32
3
1 1 2 3
1 2 1 2
1 3 2 3
예제 출력 1 
63
2
36
*/


// 풀이
import java.util.*;

public class Main{
     public static void main(String []args){
    	 Scanner sc = new Scanner(System.in);
    	 int N = sc.nextInt();
    	 int M = sc.nextInt();
    	 int num[][] = new int[N][M];
    	 for(int i=0; i<N; i++) {
    		 for(int j=0; j<M; j++) {
    			 num[i][j] = sc.nextInt();
    		 }
    	 }
    	 int K = sc.nextInt();
    	 for(int g=0; g<K; g++) {
    		 int ans = 0;
    		 int i = sc.nextInt();
    		 int j = sc.nextInt();
    		 int x = sc.nextInt();
    		 int y = sc.nextInt();
    		 
    		 for(int k=i-1; k<=x-1; k++) {
    			 for(int l=j-1; l<=y-1; l++) {
    				 ans += num[k][l];
    			 }
    		 }
    		 System.out.println(ans);
    	 }
     }
}
