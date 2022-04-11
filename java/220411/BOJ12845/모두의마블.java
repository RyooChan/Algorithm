import java.util.*;

public class MyClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int golds[] = new int[N];
        
        for(int i=0; i<N; i++) golds[i] = sc.nextInt();
        
        int max = 0; 
        int maxIndex = 0; 
        int ans = 0;
        for(int i=0; i<golds.length; i++) { 
            int level = golds[i]; 
            if (max < level) { 
                max = level; 
                maxIndex = i; 
            } 
            ans += level; 
        } 
        ans += max * (golds.length - 2);
        System.out.println(ans);
    }
}
