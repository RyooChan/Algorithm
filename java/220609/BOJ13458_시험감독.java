import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int num[] = new int[N];
        for(int i=0; i<N; i++) num[i] = sc.nextInt();
        int mainM = sc.nextInt();
        int subM = sc.nextInt();
        
        long ans = N;
        for(int i=0; i<N; i++){
            num[i] -= mainM;
            if(num[i]>0){
                ans += num[i]/subM;
                if(num[i]%subM != 0){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
