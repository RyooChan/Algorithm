/*
뒤집기 성공분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	6593	3325	2613	50.787%
문제
다솜이는 0과 1로만 이루어진 문자열 S를 가지고 있다. 다솜이는 이 문자열 S에 있는 모든 숫자를 전부 같게 만들려고 한다. 다솜이가 할 수 있는 행동은 S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다. 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.

예를 들어 S=0001100 일 때,

전체를 뒤집으면 1110011이 된다.
4번째 문자부터 5번째 문자까지 뒤집으면 1111111이 되어서 2번 만에 모두 같은 숫자로 만들 수 있다.
하지만, 처음부터 4번째 문자부터 5번째 문자까지 문자를 뒤집으면 한 번에 0000000이 되어서 1번 만에 모두 같은 숫자로 만들 수 있다.

문자열 S가 주어졌을 때, 다솜이가 해야하는 행동의 최소 횟수를 출력하시오.

입력
첫째 줄에 문자열 S가 주어진다. S의 길이는 100만보다 작다.

출력
첫째 줄에 다솜이가 해야하는 행동의 최소 횟수를 출력한다.

예제 입력 1 
0001100
예제 출력 1 
1
*/

// 풀이
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {	
	public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String num = (br.readLine());
        // 0과 1로 이루어진 덩어리를 비교하여 더 적은 덩어리가 답이 된다.
        
        // 현재 글자를 받다가, 0->1 / 1->0 처럼 덩어리가 바뀌는 때에 덩어리 개수를 늘리고 현재 글자를 바꿔주면 된다
        char now;
        // compare에 덩어리를 저장한다. compare[0]은 0, compare[1]은 1덩어리이다.
        int compare[] = new int[2];
        int ans;
        
        // 첫글자를 받는다. 첫글자의 덩어리는 바로 적어준다.
        now = num.charAt(0);
		      compare[(int)num.charAt(0) - 48]++;

        // 다음 문자부터 확인하여 해당 0 / 1 덩어리를 받아준다.
        for(int i=1; i<num.length(); i++)
        {
          // 그렇게 다음 덩어리로 가면 해당 덩어리의 숫자로 now를 바꾸어 주고, ascii code에서 0은 48, 1은 49이기 때문에 그렇게 만들어준다.
        	if(num.charAt(i)!=now)
        	{
        		compare[(int)num.charAt(i) - 48]++;
        		now = num.charAt(i);
        	}
        }
        
        // 각각의 덩어리를 비교하여 더 적은 쪽이 답이 된다.
        if(compare[0] <= compare[1])
        	ans = compare[0];
        else
        	ans = compare[1];
		

		 
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
		
	}

}
	
