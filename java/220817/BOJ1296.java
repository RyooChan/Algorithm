import java.util.*;

public class Main
{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int ans = 0;
        
        for(int i=0; i<N+M; i++){
            int num = sc.nextInt();
            if(hm.getOrDefault(num, 0) == 1){
                hm.put(num, 0);
                ans--;
            }else{
                hm.put(num, 1);
                ans++;
            }
        }
        System.out.println(ans);
	}
}
