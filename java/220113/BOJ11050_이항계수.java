import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        long ans = ( factorial(N) / ( factorial(N-K) * factorial(K) ) ) % 10007;

      System.out.println(ans);
    }
    public static long factorial(int input){
        if(input<=1){
            return 1;
        }else{
            return input*factorial(input-1);
        }
    }
}
