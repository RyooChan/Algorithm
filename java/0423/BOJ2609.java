/*
최대공약수와 최소공배수 성공출처분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	38169	22722	18606	62.373%
문제
두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

출력
첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.

예제 입력 1 
24 18
예제 출력 1 
6
72
*/

// 풀이
import java.util.*;

public class Main {
    public static void main(String args[]) {		
        int A, B;
        //최대공약수 최소 1
        int max = 1;
        int temp;
        int cnt = 1;
        Scanner sc = new Scanner(System.in);
        
        A = sc.nextInt();
        B = sc.nextInt();
        // B가 A보다 크면 위치 바꾸기
        if(A<B){
            temp = B;
            B = A;
            A = temp;
        }
        // 최소공배수는 더 큰수가 최소값
        int min = A;
        
        // A까지 진행하면서 i가 A의 약수이면 B의 약수인지 판단하여 max에 넣고 끝까지 가면 최대공약수
        for(int i=1; i<=A; i++){
            if(A%i == 0){
                if(B%i == 0){
                    max = i;
                }
            }
        }
        
        // 최소공배수는 A의 어떤 배수가 B로 나뉘는 순간 나오면 된다.
        while(min % B != 0){
            min = A * cnt;
            cnt++;
        }
        
        System.out.println(max);
        System.out.println(min);
    }
}
