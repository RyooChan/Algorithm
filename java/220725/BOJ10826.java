import java.util.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		if (N == 0) {
            System.out.println(0);
		} else if (N == 1) {
            System.out.println(1);
		} else {
			BigInteger[] dp = new BigInteger[N + 1];

			dp[0] = BigInteger.ZERO;
			dp[1] = BigInteger.ONE;
			for (int i = 2; i <= N; i++) {
				dp[i] = dp[i - 2].add(dp[i - 1]);
			}

            System.out.println(dp[N]);
		}
	}
}
