import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int num[] = new int[N+1];
        int length[] = new int[N+1];
        
        for(int i=1; i<=N; i++) num[i] = sc.nextInt();
        
        length[1] = 1;
        int ans = 1;
        
        for(int i=2; i<=N; i++){
            for(int j=0; j<i; j++){
                if(num[j] > num[i]){
                     length[i] = Math.max(length[j], length[i]);
                }
            }
            length[i]++;
            ans = Math.max(ans, length[i]);
        }
        System.out.println(ans);
    }
}
