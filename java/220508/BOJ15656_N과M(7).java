import java.util.*;

public class Main {
    public static int N, M;
    public static int num[];
    public static StringBuilder sb;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        num = new int[N];
        for(int i=0; i<N; i++) num[i] = sc.nextInt();
        Arrays.sort(num);
        
        for(int i=0; i<N; i++){
            maker(i, 1, num[i] + "");
        } 
        System.out.println(sb);
      
    }
    public static void maker(int now, int depth, String str){
        if(depth == M){
            sb.append(str + "\n");
            return;
        }
        
        for(int i=0; i<N; i++){
            maker(i, depth+1, str + " " + num[i]);
        }
        
    }
}
