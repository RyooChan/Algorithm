import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        int N;
        long num[][] = new long[100002][4];
        num[1][1] = 1;
        num[2][2] = 1;
        num[3][1] = 1;
        num[3][2] = 1;
        num[3][3] = 1;
        
        for(int i=4; i<100002; i++){
            num[i][1] = (num[i-1][2] + num[i-1][3])%1000000009;
            num[i][2] = (num[i-2][1] + num[i-2][3])%1000000009;
            num[i][3] = (num[i-3][1] + num[i-3][2])%1000000009;
        }
        
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            N = sc.nextInt();
            sb.append((num[N][1]+num[N][2]+num[N][3])%1000000009 + "\n");
            
        }
        System.out.println(sb.toString());
    }
}
