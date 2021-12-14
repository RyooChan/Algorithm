/*
로마 숫자 성공출처분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	2116	936	806	48.848%
문제
로마 시대 때는 현재 사용하는 아라비아 숫자가 아닌 다른 방법으로 수를 표현하였다.

로마 숫자는 다음과 같은 7개의 기호로 이루어진다.

기호	I	V	X	L	C	D	M
값	1	5	10	50	100	500	1000
수를 만드는 규칙은 다음과 같다.

보통 큰 숫자를 왼쪽에 작은 숫자를 오른쪽에 쓴다. 그리고 그 값은 모든 숫자의 값을 더한 값이 된다. 예를 들어 LX = 50 + 10 = 60 이 되고, MLI = 1000 + 50 + 1 = 1051 이 된다.
V, L, D는 한 번만 사용할 수 있고 I, X, C, M은 연속해서 세 번까지만 사용할 수 있다. 예를 들어 VV나 LXIIII 와 같은 수는 없다. 그리고 같은 숫자가 반복되면 그 값은 모든 숫자의 값을 더한 값이 된다. 예를 들어 XXX = 10 + 10 + 10 = 30 이 되고, CCLIII = 100 + 100 + 50 + 1 + 1 + 1 = 253 이 된다.
작은 숫자가 큰 숫자의 왼쪽에 오는 경우는 다음과 같다. IV = 4, IX = 9, XL = 40, XC = 90, CD = 400, CM = 900 을 나타낸다. 이들 각각은 한 번씩만 사용할 수 있다. 그런데 IV 와 IX 는 같이 쓸 수 없으며 XL 과 XC, CD 와 CM 또한 같이 쓸 수 없다. 이들 외에는 작은 숫자가 큰 숫자 왼쪽 어디에도 나올 수 없다. 예를 들어 XCXC 나 CMCD, VX 나 IIX 와 같은 수는 없다. 참고로 LIX = 50 + 9 = 59, CXC = 100 + 90 = 190 이 된다.
모든 수는 가능한 가장 적은 개수의 로마 숫자들로 표현해야 한다. 예를 들어 60 은 LX 이지 XLXX 가 아니고, 5 는 V 이지 IVI 가 아니다.
아래의 예를 참고 하시오.

DLIII = 500 + 50 + 3 = 553
MCMXL = 1000 + 900 + 40 = 1940
235 = CCXXXV
2493 = MMCDXCIII
로마 숫자로 이루어진 두 수를 입력받아 그 둘을 더한 값을 아라비아 숫자와 로마 숫자로 출력하는 프로그램을 작성하시오.

입력
첫째 줄과 둘째 줄에 하나씩 로마 숫자로 표현된 수가 주어진다. 입력된 각 수는 2000 보다 작거나 같고, 두 수의 합은 4000보다 작다.

출력
입력으로 주어진 두 수를 더한 값을 첫째 줄에 아라비아숫자로 출력하고 둘째 줄에는 로마 숫자로 출력한다.

예제 입력 1 
DLIII
MCMXL
예제 출력 1 
2493
MMCDXCIII
*/

// 풀이
import java.util.*;
 
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input1 = sc.next();
		String input2 = sc.next();

    // 그냥 전체에서 4, 9, 40, 90...이것들을 다 바꾸어 준다. 이미 로마 숫자로 있는 경우 제외하고 새로운 단어로 바꾸어 char로 판단하도록 한다.
		input1 = input1.replaceAll("IV", "A");
		input1 = input1.replaceAll("IX", "B");
		input1 = input1.replaceAll("XL", "E");
		input1 = input1.replaceAll("XC", "F");
		input1 = input1.replaceAll("CD", "G");
		input1 = input1.replaceAll("CM", "H");
		
		input2 = input2.replaceAll("IV", "A");
		input2 = input2.replaceAll("IX", "B");
		input2 = input2.replaceAll("XL", "E");
		input2 = input2.replaceAll("XC", "F");
		input2 = input2.replaceAll("CD", "G");
		input2 = input2.replaceAll("CM", "H");

    // 각각 글자들을 char형식 배열로 정하고, 아라비아 숫자로 바꿀 firstNum, secondNum을 선언한다.
		char first[] = input1.toCharArray();
		int firstNum = 0;
		char second[] = input2.toCharArray();
		int secondNum = 0;

    // 글자들을 하나씩 판단하여 숫자로 바꾸어 적어 준다.
		for(char i : first)
			firstNum += charChanger(i);
		for(char i : second)
			secondNum += charChanger(i);
		
    // 결과값 숫자형
		int resultNum = firstNum + secondNum;
    // 다시 로마 숫자로 표현할 resultString
		String resultString = numChanger(resultNum);
		
		System.out.println(resultNum);
		System.out.println(resultString);
		
	}
  
  // 이곳에서 숫자로 바꾸는 경우를 수행한다.
	public static int charChanger(char input) {
		int comp = 0;
		
    // 각각1, 5, ......, 1000 그리고 특수한 경우 위에서 세팅한 문자를 받아서 설정한다. 혹시 이상한 문제가 들어오면 -99999로 알아보게 하였다.
		if(input == 'I') comp = 1;
		else if(input == 'V') comp = 5;
		else if(input == 'X') comp = 10;
		else if(input == 'L') comp = 50;
		else if(input == 'C') comp = 100;
		else if(input == 'D') comp = 500;
		else if(input == 'M') comp = 1000;
		else if(input == 'A') comp = 4;
		else if(input == 'B') comp = 9;
		else if(input == 'E') comp = 40;
		else if(input == 'F') comp = 90;
		else if(input == 'G') comp = 400;
		else if(input == 'H') comp = 900;
		else comp = -99999999;
		
		return comp;
	}
	
	// 이곳에서는 다시 로마문자로 바꾼다.
	public static String numChanger(int input) {
		String re = "";
		
    // 1, 2, 3의 경우가 있을 수 있으니 모든 경우를 고려하도록 while사용
		while(input >= 1000) {
			re += "M";
			input -= 1000;
		}
    // 400, 900, 40 등은 1번밖에 안나온다.
		if(input >= 900) {
			re += "CM";
			input -= 900;
		}

		if(input >= 500) {
			re += "D";
			input -= 500;
		}

		if(input >= 400) {
			re += "CD";
			input -= 400;
		}
    // 이경우도 100, 200, 300
		while(input >= 100) {
			re += "C";
			input -= 100;
		}

		if(input >= 90) {
			re += "XC";
			input -= 90;
		}

		if(input >= 50) {
			re += "L";
			input -= 50;
		}

		if(input >= 40) {
			re += "XL";
			input -= 40;
		}
    // 마찬가지 수행
		while(input >= 10) {
			re += "X";
			input -= 10;
		}

		if(input >= 9) {
			re += "IX";
			input -= 9;
		}

		if(input >= 5) {
			re += "V";
			input -= 5;
		}
		
		if(input >= 4) {
			re += "IV";
			input -= 4;
		}
		// 여기도 같다.
		while(input >= 1) {
			re += "I";
			input -= 1;
		}
    // 해당 방법으로 구한 결과값 re를 반환시키면 된다.
		return re;
	}
}

// 문제 자체는 굉장히 쉬웠는데, 더 효율적인 방법을 찾아야 할 것 같다.
