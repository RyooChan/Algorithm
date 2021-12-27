import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        PriorityQueue<Long> num = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            num.add(sc.nextLong());
        }
        
        for(int i=0; i<M; i++){
            long make = num.poll() + num.poll();
            num.add(make);
            num.add(make);
        }
        
        long sum = 0;
        while(!num.isEmpty()) sum += num.poll();
        
        System.out.println(sum);
    }
}
