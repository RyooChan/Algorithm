import java.util.*;

public class Main {
    public static int N;
    public static int ans = 0;
    public static int num[] = {1, 5, 10, 50};
    public static boolean check[];
    
    public static HashSet<Integer> cut = new HashSet<>();
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        check = new boolean[10001];
        
        for(int i=0; i<4; i++){
            maker(1, i, num[i]);
        } 
        System.out.println(ans);
      
    }
    public static void maker(int depth, int loc, int now){
        if(depth == N){
            if(!check[now]){
                check[now] = true;
                ans++;
            }
            return;
        }
        
        for(int i=loc; i<4; i++){
            maker(depth+1, i, now + num[i]);
        }
        
    }
}
