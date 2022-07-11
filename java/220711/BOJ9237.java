import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        Integer num[] = new Integer[N];
        
        for(int i=0; i<N; i++) num[i] = sc.nextInt();
        Arrays.sort(num, Comparator.reverseOrder());
        
        Integer max = 0;
        for(int i=0; i<N; i++){
            num[i] += (i+1);
            max = Math.max(max, num[i]);
        } 
        
        System.out.println(max+1);
        
    }
}
