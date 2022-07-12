import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        Integer num[] = new Integer[N];
        
        for(int i=0; i<N; i++) num[i] = sc.nextInt();
        Arrays.sort(num, Collections.reverseOrder());
        
        long tip = 0;
        
        for(int i=0; i<N; i++){
            tip += Math.max(0, num[i]-i);
        }
        
        System.out.println(tip);
    }
}
