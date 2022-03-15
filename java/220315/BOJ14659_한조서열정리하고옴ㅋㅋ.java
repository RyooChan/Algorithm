import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int hill[] = new int[N];
        
        for(int i=0; i<N; i++) hill[i] = sc.nextInt();
        
        int ans = 0;
        for(int i=0; i<N; i++){
            int cnt = 0;
            for(int j=i+1; j<N; j++){
                if(hill[i] > hill[j]) cnt++;
                else break;
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
}
