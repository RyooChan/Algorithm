import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int M = sc.nextInt();
        int N = sc.nextInt();
        
        int snack[] = new int[N];
        
        for(int i=0; i<N; i++) snack[i] = sc.nextInt();
        
        Arrays.sort(snack);
        
        int left = 1;
        int right = snack[N-1];
        
        int ans = 0;
        while(left <= right){
            int mid = (left + right)/2;
            int cnt = 0;
            
            for(int i=0; i<N; i++) cnt += snack[i]/mid;
            
            if(cnt >= M){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid-1;
            }
            
        }
        System.out.println(ans);
    }
}
