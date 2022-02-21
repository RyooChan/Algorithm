import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        if (K >= N){
            System.out.println("0");
            return;
        }
        
        int sensor[] = new int[N];
        
        for(int i=0; i<N; i++) sensor[i] = sc.nextInt();
        
        Arrays.sort(sensor);
        
        PriorityQueue<Integer> gap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<N-1; i++){
            gap.add(sensor[i+1] - sensor[i]);
        }
        
        for(int i=0; i<K-1; i++) gap.remove();
        
        int sum = 0;
        
        while(!gap.isEmpty()) sum += gap.poll();
        
        System.out.println(sum);
    }
}

// 해설 https://hello-backend.tistory.com/108
