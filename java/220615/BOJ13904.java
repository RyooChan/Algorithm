import java.util.*;

class info implements Comparable<info>{
    int time;
    int point;
    
    info(int time, int point){
        this.time = time;
        this.point = point;
    }
    
    @Override
    public int compareTo(info o){
        return this.time - o.time;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<info> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int N = sc.nextInt();
        int timeEnd = 0;
        for(int i=0; i<N; i++){
            int time = sc.nextInt();
            int point = sc.nextInt();
            timeEnd = Math.max(timeEnd, time);
            
            pq.add(new info(time, point));
        }
        
        int ans = 0;
        PriorityQueue<info> temp = new PriorityQueue<>(Collections.reverseOrder());
        while(!pq.isEmpty()){
            info info = pq.remove();
            
            int time = info.time;
            int point = info.point;
            int maxPoint = 0;
            if(time >= timeEnd) maxPoint = point;
            
            while(!pq.isEmpty()){
                if(pq.peek().time >= timeEnd){
                    info info2 = pq.remove();
                    maxPoint = Math.max(maxPoint, info2.point);
                    temp.add(info2);
                }else break;
            }
            ans += maxPoint;
            
            if(point == maxPoint){
                while(!temp.isEmpty()){
                    pq.add(temp.remove());
                }
            }else{
                pq.add(info);
                while(!temp.isEmpty()){
                    if(temp.peek().point == maxPoint){
                        temp.remove();
                        maxPoint = -1;
                        continue;
                    }
                    pq.add(temp.remove());
                }
            }
            timeEnd--;
            if(timeEnd==0) break;
        }
        System.out.println(ans);
        
    }
}
