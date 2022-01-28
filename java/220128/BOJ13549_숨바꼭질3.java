import java.util.*;

public class Main {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int fastestTime = 200000;
        int distance = 200001;
        
        boolean check[] = new boolean[200001];
        
        Queue<info> finder = new LinkedList<>();
        
        finder.add(new info(N, 0));
        while(!finder.isEmpty()){
            info info = finder.poll();
            int loc = info.loc;
            int time = info.time;
            
            check[loc] = true;
            
            if(loc == K){
                distance = Math.min(time, distance);
                // fastestTime = Math.min(time, fastestTime);
            }
            
            if(fastestTime>=loc*2 && !check[loc*2] )finder.add(new info(loc*2, time));
            if(fastestTime>=loc+1 && !check[loc+1] )finder.add(new info(loc+1, time+1));
            if(0<=loc-1 && !check[loc-1] )finder.add(new info(loc-1, time+1));
        }
        
        System.out.println(distance);
    }
}
class info{
    int loc;
    int time;
    info(int loc, int time){
        this.loc = loc;
        this.time = time;
    }
}
