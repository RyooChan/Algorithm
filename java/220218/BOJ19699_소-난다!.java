import java.util.*;

public class MyClass {
    public static int cows[];
    public static boolean check[];
    public static boolean prime[];
    public static int N, M;
    public static TreeSet<Integer> can = new TreeSet<>((o1,o2)->o1-o2);
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        cows = new int[N];
        check = new boolean[N];
        
        for(int i=0; i<N; i++) cows[i] = sc.nextInt();
        Arrays.sort(cows);
        
        int cnt = 0;
        for(int i=0; i<M; i++){
            cnt += cows[cows.length-1-i];
        }
        prime = new boolean[cnt+1];
        get_prime();
        
        weight(0, 0, 0);
        if(can.isEmpty()) System.out.println("-1");
        else for(int i : can) System.out.print(i + " ");
        
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
	public static void weight(int loc, int cnt, int sum){
	    if(cnt==M){
            if(!prime[sum]) can.add(sum);
            return;
	    }
	    
	    for(int i=loc; i<N; i++){
	        if(check[i]) continue;
	        check[i] = true;
	        sum += cows[i];
    	    weight(loc+1, cnt+1, sum);
	        sum -= cows[i];
	        check[i] = false;
	    }
	    
	}
}
