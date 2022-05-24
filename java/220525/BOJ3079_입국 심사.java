import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long M = sc.nextLong();
        
        long num[] = new long[N];
        for(int i=0; i<N; i++) num[i] = sc.nextLong();
        
        Arrays.sort(num);
        
        long start = 0L;
        long end = (long)num[N-1]*M;
        
        long ans = 0;
        while(start <= end){
            long mid = (long)(start+end)/2;
            long cnt = 0;
            for(int i=0; i<N; i++){
                cnt+=mid/num[i];
            }
            if(cnt>=M){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        System.out.println(ans);
    }
}
