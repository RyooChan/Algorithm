import java.util.*;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		int num = sc.nextInt();
 
		int ans = 0;
		while (num >= 5) {
			ans += num / 5;
			num /= 5;
		}
		System.out.println(ans);
	}
 
}
