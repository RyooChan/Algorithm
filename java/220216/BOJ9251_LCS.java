import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        String A = sc.next();
        String B = sc.next();
        
        char first[] = A.toCharArray();
        char second[] = B.toCharArray();
        
        int cnt[][] = new int[first.length+1][second.length+1];
        
		for(int i = 0; i <= first.length; i++)
			cnt[i][0] = 0;
		for(int i = 0; i <= second.length; i++)
			cnt[0][i] = 0;
        
        for(int i=1; i<cnt.length; i++){
            for(int j=1; j<cnt[0].length; j++){
				if(first[i-1] == second[j-1])
					cnt[i][j] = cnt[i-1][j-1] +1;
				else 
					cnt[i][j] = Math.max(cnt[i-1][j], cnt[i][j-1]);
            }
        }
        System.out.println(cnt[first.length][second.length]);
        

    }
}
