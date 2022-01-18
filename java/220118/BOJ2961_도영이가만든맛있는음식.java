import java.util.*;

public class Main {
    public static int sour[];
    public static int bitter[];
    public static boolean check[];
    public static int ans = Integer.MAX_VALUE;
    public static int N;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sour = new int[N];
        bitter = new int[N];
        check = new boolean[N];
        
        for(int i=0; i<N; i++){
            sour[i] = sc.nextInt();
            bitter[i] = sc.nextInt();
        }
        
        DFS(0, 0, 1);
        System.out.println(ans);
    }
    public static void DFS(int level, int bit, int sou){
        if(level != 0) ans = Math.min(Math.abs(bit-sou), ans);
        
        for(int i=0; i<N; i++){
            if(check[i]) continue;
            check[i] = true;
            DFS(level+1, bit+bitter[i], sou*sour[i]);
            check[i] = false;
        }
    }
}
