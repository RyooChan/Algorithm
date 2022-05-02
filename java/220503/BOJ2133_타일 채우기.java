import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int tile[] = new int[N+1];

        tile[0] = 1;
        for(int i=2; i<=N; i+=2){
            tile[i] = tile[i-2]*3;
            for(int j=i-4; j>=0; j-=2){
                tile[i] += tile[j]*2;
            }
        }
        
        System.out.println(tile[N]);
    }
}
