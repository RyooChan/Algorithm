import java.util.*;
public class Main{
    
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        for(int i=1; i<K+1; i++) {
            N -= i;
            if(N < 0) {
                System.out.println(-1);
                return;
            }
        } 
        
        if(N >= 0) {
            if(N%K > 0) {
               System.out.println(K);
            }else {
                System.out.println(K-1);
            }
        }
    }
}
