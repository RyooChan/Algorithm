/*
단어 수학 성공분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	256 MB	12180	5129	3837	42.824%
문제
민식이는 수학학원에서 단어 수학 문제를 푸는 숙제를 받았다.

단어 수학 문제는 N개의 단어로 이루어져 있으며, 각 단어는 알파벳 대문자로만 이루어져 있다. 이때, 각 알파벳 대문자를 0부터 9까지의 숫자 중 하나로 바꿔서 N개의 수를 합하는 문제이다. 같은 알파벳은 같은 숫자로 바꿔야 하며, 두 개 이상의 알파벳이 같은 숫자로 바뀌어지면 안 된다.

예를 들어, GCF + ACDEB를 계산한다고 할 때, A = 9, B = 4, C = 8, D = 6, E = 5, F = 3, G = 7로 결정한다면, 두 수의 합은 99437이 되어서 최대가 될 것이다.

N개의 단어가 주어졌을 때, 그 수의 합을 최대로 만드는 프로그램을 작성하시오.

입력
첫째 줄에 단어의 개수 N(1 ≤ N ≤ 10)이 주어진다. 둘째 줄부터 N개의 줄에 단어가 한 줄에 하나씩 주어진다. 단어는 알파벳 대문자로만 이루어져있다. 모든 단어에 포함되어 있는 알파벳은 최대 10개이고, 수의 최대 길이는 8이다. 서로 다른 문자는 서로 다른 숫자를 나타낸다.

출력
첫째 줄에 주어진 단어의 합의 최댓값을 출력한다.

예제 입력 1 
2
AAA
AAA
예제 출력 1 
1998
예제 입력 2 
2
GCF
ACDEB
예제 출력 2 
99437
예제 입력 3 
10
A
B
C
D
E
F
G
H
I
J
예제 출력 3 
45
*/


// 풀이
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.IOException; 
public class Main {

	public static void main(String[] args) throws IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
        // 입력될 알파벳의 개수 N개만큼 input을 통해 line을 입력받을 것이다.
        String input[] = new String[N];	
        // 알파벳 A~Z까지 입력될텐데 그 값들의 자리수를 비교할 alpha배열이다.
        int alpha[] = new int[26];
        
        // 테스트 케이스만큼 진행
		for(int i=0; i<N; i++)
		{
            // 알파벳 문자열 입력받는다.
            input[i] = br.readLine();
            // 그래서 문자열 길이만큼 구해서
            for(int j=0; j<input[i].length(); j++)
                alpha[(int)input[i].charAt(input[i].length()-j-1)-65] += Math.pow(10, j);
                // 자리수를 구한다. charAt(0)은 맨 처음이니까 뒤부터 계산하기위해 length부터 빼준다. 대문자의 ASCII코드는 A가 65부터 진행되므로 65를 빼면 0에 A의 해당 자리수를 구할 수 있다.
                // 가장 큰 자리수에 해당하는 알파뱃를 9로 만들고 점점 빼가면 최대의 숫자를 만들 수 있을 것이다.
            
		}
		
        // A~Z까지 어떤 자리수에 나왔는지 구했기 때문에 sort해 준다.
        // 원래 내림차순으로 정렬하려 했는데 Integer로 바꿔야해서 코드가 지저분해져서 sort사용
		Arrays.sort(alpha);
        
        // 각각의 자리수에 맞춰 가중치 9부터 내려가면서 구해주면 된다.
		int weight = 9;
		int ans = 0;
        
        // 가장 큰 숫자부터 가중치를 곱해서 ans에 더해주면 된다.
		for(int i=25; i>0; i--)
			ans += alpha[i] * (weight--);

		
		System.out.println(ans);
	}

}
