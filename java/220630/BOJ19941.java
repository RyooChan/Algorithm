import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        String input = sc.next();
        String numStr[] = input.split("");
        char num[] = new char[N];
        
        for(int i=0; i<N; i++){
            num[i] = numStr[i].charAt(0);
        }
        
        int ans = 0;
        for(int i=0; i<N; i++){
            if(num[i] == 'P'){
                int start = Math.max(0, i-K);
                int end = Math.min(N-1, i+K);
                for(int j=start; j<=end; j++){
                    if(num[j]=='H'){
                        ans++;
                        num[j] = 'D';
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
