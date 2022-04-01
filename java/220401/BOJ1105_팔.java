import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        String A = sc.next();
        String B = sc.next();
        
        int ans = 0;
        if(A.length() == B.length()) {
            for(int i=0; i<A.length(); i++){
                if((A.charAt(i) == B.charAt(i)) && A.charAt(i)=='8') ans++;
                else if(A.charAt(i) != B.charAt(i)) break;
            }
        }
        System.out.println(ans);
    }
}
