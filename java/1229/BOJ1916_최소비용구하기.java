import java.util.*;

class info implements Comparable<info>{
    int end;
    int cost;
    
    info(int end, int cost){
        this.end = end;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(info o) {
        return this.cost - o.cost;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        
        ArrayList<ArrayList<info>> bus = new ArrayList<>();
        
        for(int i=0; i<N+1; i++) bus.add(new ArrayList<>());  // 전체 node범위에 대해 초기화 시켜주기

        for(int i=0; i<M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();
            // ArrayList<info> toAdd = new ArrayList<>();
            // toAdd.add(new info(end, cost));
            bus.get(start).add(new info(end, cost));    // arraylist내에 arraylist가 선언되어 1아래에 (2, 2) (3, 3) (4, 1) 이렇게 생길 수 있도록 함.
        }
        
        int fromCity = sc.nextInt();
        int toCity = sc.nextInt();
        
        PriorityQueue<info> finder = new PriorityQueue<>();
        int money[] = new int[N+1];
        boolean check[] = new boolean[N+1];
        finder.add(new info(fromCity, 0));  // 처음 도시로 가는 비용은? 0원이지
        
        for(int i=0; i<N+1; i++) money[i] = Integer.MAX_VALUE;
        money[fromCity] = 0;
        
        while(!finder.isEmpty()){
            info nowCity = finder.poll();
            int start = nowCity.end;
            int nowCost = nowCity.cost;
            if(check[start]) continue;
            check[start] = true;
            for(info info : bus.get(start)){
                int end = info.end;
                int cost = info.cost;
                if( check[end] ) continue;
                if( money[start] + cost < money[end] ){
                    money[end] = money[start] + cost;
                    finder.add(new info(end, money[end]));
                }
            }
        }
        System.out.println(money[toCity]);
    }
}



// 해설 https://hello-backend.tistory.com/96
