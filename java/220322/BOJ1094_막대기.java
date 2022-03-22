import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int cnt = 64;
        int ans = 0;
        while(N > 0){
            if(N<cnt){
                cnt /= 2;
                continue;
            } 
            
            N -= cnt;
            ans++;
        }
        System.out.println(ans);
        
    }
}
