import java.util.*;

class info{
    int num;
    int dis;
    
    info(int num, int dis){
        this.num = num;
        this.dis = dis;
    }
}
public class Main {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList< ArrayList<Integer> > barn = new ArrayList<>();
        
        // 헛간의 개수 -> 최대 헛간은 N
        for(int i=0; i<N+1; i++) barn.add(new ArrayList<>());
        
        // 헛간 트리 연결
        for(int i=0; i<M; i++){
            int one = sc.nextInt();
            int two = sc.nextInt();
            barn.get(one).add(two);
            barn.get(two).add(one);
        }
        
        int map[] = new int[N+1];
        for(int i=1; i<N+1; i++) map[i] = Integer.MAX_VALUE;
        
        Queue<info> finder = new LinkedList<>();
        
        boolean check[] = new boolean[N+1];
        
        // 시작점 - 자체 거리
        finder.add(new info(1, 0));
        check[1] = true;  // 시작점 -> 다시 갈일없고
        
        
        int ansBarn = N+1;
        int maxDis = Integer.MIN_VALUE;     // 최대 거리
        int cnt = 1;
        while(!finder.isEmpty()){
            info info = finder.remove();
            int num = info.num;
            int dis = info.dis;
            
            if(maxDis < dis){
                maxDis = dis;
                ansBarn = num;
                cnt=1;
            }else if(maxDis == dis){
                cnt++;
                
                ansBarn = Math.min(ansBarn, num);
            }
            
            for(Integer go : barn.get(num)){
                if(check[go]) continue;
                check[go] = true;
                
                finder.add(new info(go, dis+1));
            }
        }
        
        System.out.println(ansBarn + " " + maxDis + " " + cnt);
    }
}
