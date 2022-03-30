import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        StringBuffer S = new StringBuffer(sc.next());
        StringBuffer T = new StringBuffer(sc.next());
        
        int ans = 0;
        
        while(S.length() < T.length()){
            int loc = T.length() - 1;
            
            if(T.charAt(loc) == 'A' ){
                T.deleteCharAt(loc);
            }else{
                T.deleteCharAt(loc);
                T.reverse();
            }
        }
        String a = S.toString();
        String b = T.toString();
        
        if(a.equals(b)) ans = 1;
        System.out.println(ans);
    }
}
