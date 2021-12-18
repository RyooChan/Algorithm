import java.util.*;
 
public class Main {
	public static boolean[] prime;
	public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
 
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int start = (int)Math.pow(10, N-1);
		int last = (int)Math.pow(10, N);
		
		prime = new boolean[last+1];
		get_prime();
				
		for(int i=start ; i<=last; i++) {
			if(!checker(i)) sb.append(i+"\n");
		}
        System.out.println(sb);
	}
 
	public static void get_prime() {
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) continue;
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
	
	public static boolean checker(int num){
	    if(prime[num]) return true;
	    if(num>9){
    	    String str = num + "";
    	    int next = Integer.parseInt(str.substring(0, str.length()-1));
    	    return checker(next);
	    }
	    return false;
	}
	
}
