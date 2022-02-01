import java.util.*;


// BOJ9663_nQueen.java
public class Main {
	public static int locate[];
	public static int N;
	public static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		locate = new int[N];

		check(0);
		System.out.println(ans);
	}
	
	public static void check(int loc) {
		if(loc==N) {
			ans++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			locate[loc] = i;
			boolean canLoc = queen(loc);
			if(canLoc) check(loc+1);
		}
		
	}
	public static boolean queen(int loc) {
		
		for(int i=0; i<loc; i++) {
			if(locate[loc] == locate[i]) return false;
			else if( ( Math.abs(locate[i]-locate[loc]) - Math.abs(i-loc) ) == 0 ) return false;
		}
		
		return true;
	}

}
