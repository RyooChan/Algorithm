import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(T-->0){
            int N = sc.nextInt();
            if(N==1){
               System.out.println(1); 
               continue; 
            } 
            else if(N==2) {
                System.out.println(2); 
                continue;
            }
            else if(N==3){
                System.out.println(4); 
                continue;
            } 
            
            long num[] = new long[N+1];
            num[1] = 1;
            num[2] = 2;
            num[3] = 4;
            
            for(int i=4; i<=N; i++){
                num[i] = (num[i-1] + num[i-2] + num[i-3]) % 1000000009;
            }
            System.out.println(num[N]);
        }
        
        
    }
}
