import java.util.*;

public class Main {
    public static int N, M;
    public static int num[];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        num = new int[N];
        for(int i=0; i<N; i++) num[i] = sc.nextInt();
        Arrays.sort(num);
        
        for(int i=0; i<N; i++){
            maker(i, 1, num[i] + "");
        }
      
    }
    public static void maker(int now, int depth, String str){
        if(depth == M){
            System.out.println(str);
            return;
        }
        
        for(int i=now; i<N; i++){
            maker(i, depth+1, str + " " + num[i]);
        }
        
    }
}
