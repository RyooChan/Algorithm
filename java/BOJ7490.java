import java.util.*;

public class Main {
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());

        while(T-->0) {
            N = sc.nextInt();
            validater(1, "1"); // 1부터 시작한다.
            System.out.println();
        }
    }

    private static void validater(int now, String str) {
        // 원하는 숫자에 도달하면
        if (now == N) {
            calculater(str); // 계산하기
            return;
        }
        // 1부터 시작했으니 값을 하나씩 늘려가면서 확인한다.
        now++;

        // ASCII 순서로 각 연산자에 맞춰서 DFS 처리한다.
        validater(now, str + " " + now);
        validater(now, str + "+" + now);
        validater(now, str + "-" + now);
    }

    private static void calculater(String input) {
        String str = input.replace(" ", ""); // 숫자 이어붙이기
        
        // 이걸 통해서 연산자를 뽑아낸다.
        LinkedList<Character> q = new LinkedList<>();
        for(int i=0; i<str.length(); i++) {
            char del = str.charAt(i);
            if (del == '+') {
                q.add('+');
            } else if (del == '-') {
                q.add('-');
            }
        }
        
        // 연산자를 빼고 이제는 숫자를 뽑아낸다.
        String numStrList[] = str.split("[+-]");
        
        // 처음 숫자부터 시작해서 연산해 준다.
        int num = Integer.parseInt(numStrList[0]);
        for(int i=1; i<numStrList.length; i++) {
            int now = Integer.parseInt(numStrList[i]);
            if (q.remove() == '+') {
                num += now;
            } else {
                num -= now;
            }
        }
        
        // 그 결과가 0이면 이건 출력할 수 있다.
        if (num == 0) System.out.println(input);
    }
}
