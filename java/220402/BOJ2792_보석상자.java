import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int num[] = new int[M];
        
        int left = 1;
        int right = Integer.MIN_VALUE;
        
        for(int i=0; i<M; i++){
            num[i] = sc.nextInt();
            right = Math.max(right, num[i]);
        } 
        
        int max = 0;
        int ans = 0;
        while(left <= right){
            int mid = (left+right)/2;
            int sum = 0;
        
            for(int i=0; i<M; i++){
                if(num[i] % mid == 0){
                    sum += num[i]/mid;
                }else{
                    sum += num[i]/mid + 1;
                }
            }
            
            if(sum > N){
                left = mid+1;
            }else{
                right = mid-1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }
}

// https://hello-backend.tistory.com/127
