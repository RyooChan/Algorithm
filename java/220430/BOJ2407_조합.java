import java.util.*;
import java.math.BigInteger;

public class MyClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        BigInteger n1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.ONE;

        for (int i=0; i<M; i++) {
            n1 = n1.multiply(new BigInteger(String.valueOf(N - i)));
            n2 = n2.multiply(new BigInteger(String.valueOf(i + 1)));
        }

        BigInteger answer = n1.divide(n2);

        System.out.println(answer);
    }
}
