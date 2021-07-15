/*
순열구하기
이전다음
문제
서로 다른 n개의 원소들 중에서 r개만을 뽑아 일렬로 나열하는 것을 순열이라 한다. 예를 들어, 3개의 원소 a, b, c 중에서 2개만을 뽑아 나열하면 ab, ac, ba, bc, ca, cb 의 6가지 경우가 있다. n과 r이 주어질 때, n개의 소문자 중에서 r개만을 뽑아 나열하는 모든 경우를 출력하는 프로그램을 작성하시오. 단, a부터 시작하여 연속으로 n개의 알파벳을 갖고 있다고 하자.  

입력
첫 번째 줄에 n과 r이 주어진다. ( 1 ≤ n ≤ 10, 0 ≤ r ≤ min(n, 7) )  

출력
각 줄에 n개의 소문자 중에서 r개만을 뽑아 나열하는 경우를 사전순으로 나열한 결과를 출력한다.

 

예제 입력
copy4 2
예제 출력
copyab
ac
ad
ba
bc
bd
ca
cb
cd
da
db
dc
*/

// 풀이
import java.util.*;

public class Main{
	public static int N;
	public static int R ;
	public static char[] ans;
	public static boolean[] check;
	public static char alpha[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o','p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      
      N = sc.nextInt();
      R = sc.nextInt();
      ans = new char[R];
      check = new boolean[N];
      
    	permutation(0);
    }
    
    public static void permutation(int index) {
    	if(index == R) {
    	  String output = "";
    	  for(char i : ans) output += i;
    	  System.out.println(output);
    		return;
    	}
    	
    	for(int i=0; i<N; i++) {
  			if(!check[i]) {
  				ans[index] = alpha[i];
  				check[i] = true;
  				permutation(index+1);
  				check[i] = false; 
  			}
  		}
  		return;
    }
}
