import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String A = sc.next();
		String B = sc.next();
		
		int lengDiff = B.length() - A.length();
		
		int ans = B.length();
		for(int i=0; i<=lengDiff; i++){
		    int cnt = 0;
		    for(int j=0; j<A.length(); j++){
		        if(A.charAt(j) != B.charAt(j+i)) cnt++;
		    }
		    ans = Math.min(ans, cnt);
		}
        System.out.println(ans);
    }
}

// 슬픈 날이야
