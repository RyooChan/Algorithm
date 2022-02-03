import java.util.*;

public class Main {
    public static int N, M;
    public static int num[];
    public static boolean check[];
    public static int save[];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        num = new int[N];
        for(int i=0; i<N; i++) num[i] = sc.nextInt();
        Arrays.sort(num);
        
        check = new boolean[N+1];
        save = new int[M];
        
        DFS(0, 0);
        
    }
    public static void DFS(int now, int loc){
        if(loc == M){
            for(int i : save){
                System.out.print(i + " ");
            }System.out.println();
            return;
        }
        for(int i=now; i<N; i++){
            if(check[i]) continue;
            check[i] = true;
            save[loc] = num[i];
            DFS(i+1, loc+1);
            check[i] = false;
        }
    }
}
