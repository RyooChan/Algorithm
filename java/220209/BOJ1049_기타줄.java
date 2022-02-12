import java.util.*;

public class MyClass {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int ans = Integer.MAX_VALUE;
 
        int pack[] = new int[M];
        int one[] = new int[M];
        
        for(int i=0; i<M; i++){
            pack[i] = sc.nextInt();
            one[i] = sc.nextInt();
        }
        Arrays.sort(one);
        Arrays.sort(pack);
        
        ans = Math.min( ( (N/6)+1)*pack[0], N*one[0] );    
        ans = Math.min(ans, ( (N/6))*pack[0] + (N % 6)*one[0] );
        
        System.out.println(ans);
        
    }
}
