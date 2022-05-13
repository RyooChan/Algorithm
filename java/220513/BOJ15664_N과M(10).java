import java.util.*;

public class Main {
    public static int N, M;
    public static int num[];
    // public static boolean check[];
    public static StringBuilder sb;
    public static HashSet<String> cut = new HashSet<>();
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        num = new int[N];
        // check = new boolean[N];
        for(int i=0; i<N; i++) num[i] = sc.nextInt();
        Arrays.sort(num);
        
        for(int i=0; i<N; i++){
            // check[i] = true;
            maker(i, 1, num[i] + "");
            // check[i] = false;
        } 
        System.out.println(sb);
      
    }
    public static void maker(int now, int depth, String str){
        if(depth == M){
            if(!cut.contains(str)){
                cut.add(str);
                sb.append(str + "\n");
            }
            return;
        }
        
        for(int i=now+1; i<N; i++){
            // if(check[i]) continue;
            // check[i] = true;
            maker(i, depth+1, str + " " + num[i]);
            // check[i] = false;
        }
        
    }
}
