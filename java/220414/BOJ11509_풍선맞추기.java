import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        HashMap<Integer, Integer> arrow = new HashMap<>();
        
        int N = sc.nextInt();
        int balloon[] = new int[N];
        for(int i=0; i<N; i++){
            balloon[i] = sc.nextInt();
            arrow.put(balloon[i], 0);
        } 
        
        int ans = 0;
        for(int i=0; i<N; i++){
            if( arrow.get(balloon[i]) > 0 ){
                arrow.put(balloon[i], arrow.get(balloon[i])-1);
            }else{
                ans++;
            }
		    arrow.put(balloon[i]-1, arrow.getOrDefault(balloon[i]-1, 0)+1);
        }
        System.out.println(ans);
    }
}

// https://hello-backend.tistory.com/142
