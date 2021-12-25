import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int G = sc.nextInt();
        int P = sc.nextInt();
        
        boolean accu[] = new boolean[100001];
        boolean closure = true;
        
        int ans = 0;
        
        for(int i=0; i<P; i++){
            int loc = sc.nextInt();
            if(loc>G) break;
            
            closure = true;
            for(int j=loc; j>0; j--){
                if(!accu[j]){
                    closure = false;
                    accu[j] = true;
                    ans++;
                    break;
                } 
            }
            if(closure) break;
        }
    
      System.out.println(ans);
    }
}
