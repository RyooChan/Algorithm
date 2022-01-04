import java.util.*;

public class Main {
    public static int num[];
    public static int num2[];
    public static boolean check[];
    public static int N;
    public static int answer = -101;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        num = new int[N];
        num2 = new int[N];
        check = new boolean[N];
        
        for(int i=0; i<N; i++) num[i] = sc.nextInt();
        Arrays.sort(num);
        
        bf(0);
        System.out.println(answer);
    }
    public static void bf(int cnt){
        if(cnt==N){
            int makeNum = 0;
            for(int i=0; i<N-1; i++) makeNum += Math.abs(num2[i] - num2[i+1]);
            answer = Math.max(answer, makeNum);
            return;
        }
        for(int i=0; i<N; i++){
            if(check[i]) continue;
            check[i] = true;
            num2[cnt] = num[i];
            bf(cnt+1);
            check[i] = false;
        }
    }
}
