import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int num[] = new int[N];
        int left = 0;
        int right = 0;
        
        for(int i=0; i<N; i++){
            num[i] = sc.nextInt();
            left = Math.max(left, num[i]);
            right += num[i];
        } 
        
        while(left <= right){
            int mid = (left+right)/2;
            long sum = 0;
            int cnt = 0;
            for(int i=0; i<N; i++){
                if(sum+num[i] > mid){
                    sum = 0;
                    cnt++;
                }
                sum += num[i];
            }
            if(sum != 0) cnt++;
            
            if(cnt<=M){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        System.out.println(left);
    }
}
