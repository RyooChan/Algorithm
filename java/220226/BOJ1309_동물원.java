import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int num[][] = new int[N+1][3];
        
        num[1][0] = 1;
        num[1][1] = 1;
        num[1][2] = 1;
        
        for(int i=2; i<=N; i++){
            int xx = (num[i-1][0] + num[i-1][1] + num[i-1][2])%9901;
            int xo = (num[i-1][0] + num[i-1][1])%9901;
            int ox = (num[i-1][0] + num[i-1][2])%9901;
            num[i][0] = xx;
            num[i][1] = xo;
            num[i][2] = ox;
        }
        int ans = (num[N][0] + num[N][1] + num[N][2])%9901;
        System.out.println(ans);
    }
}

// 해설 https://hello-backend.tistory.com/113
