import java.util.*;

public class Main {
	
	private static int N;
	private static boolean[] visit = new boolean[10];
	private static String[] sign;
	private static ArrayList<String> result = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		sign = new String[N];
		for (int i=0; i<N; i++) {
			sign[i] = sc.next();
		}
		
		for (int i=0; i<10; i++) {
			Arrays.fill(visit, false);
			visit[i] = true;
			cycle(i, 0, 0, i+"");
		}
		
		System.out.println(result.get(result.size()-1));
		System.out.println(result.get(0));
		
	}

	private static void cycle(int start, int idx, int cnt, String str) {
		
		if (cnt == N) {
			result.add(str);
		} else {
			for (int i=0; i<10; i++) {
				if (!visit[i]) {
					String temp = str + i; 
					if ( sign[idx].equals("<") ) {
						if (start > i)	continue;
						
						visit[i] = true; 
						cycle(i, idx+1, cnt+1, temp); 
						visit[i] = false; 
					} else if ( sign[idx].equals(">") ) {
						if (start < i)	continue;
						
						visit[i] = true; 
						cycle(i, idx+1, cnt+1, temp); 
						visit[i] = false; 
					}
				}
			}
		}
		
	}
}
