import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt() * sc.nextInt();
        int M = sc.nextInt();
        if(K<=M) System.out.println(0);
        else System.out.println(K-M);
        
    }
}
