import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int num[] = new int[N];
        
        for(int i=0; i<N; i++) num[i] = sc.nextInt();
        Arrays.sort(num);
        
        int max = Integer.MAX_VALUE;
        int sum = 0;
        int ans = num[0];
        for(int i=0; i<N; i++){
            sum = 0;
            for(int j=0; j<N; j++){
                int dif = Math.abs(num[i] - num[j]);
                sum += dif;
            }
            if(sum < max){
                max = sum;
                ans = num[i];
            }
        }
        System.out.println(ans);
    }
}
