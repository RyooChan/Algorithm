import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long M = sc.nextLong();
        
        long start = 1;
        long end = N+1;
        while(start <= end){
            long cnt = (long)start*end;
            
            if(cnt==M){
                System.out.println("YES");
                return;
            }
            start++;
            end--;
        }
        System.out.println("NO");
        
    }
}
