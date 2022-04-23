import java.util.*;

public class Main {
    public static int N;
    public static int map[];
    public static boolean numCan[];
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        map = new int[N];
        numCan = new boolean[N*100001];
        
        for(int i=0; i<N; i++) map[i] = sc.nextInt();
        Arrays.sort(map);

        BS(0, 0);
        
        for(int i=1; i<N*100001; i++){
            if(!numCan[i]) {
                System.out.println(i);
                break;
            }
        }
    }
    public static void BS(int now, int sum){
        if(now==N){    // 끝까지 가면 저장
            numCan[sum] = true;
            return;
        }
        
        BS(now+1, sum+map[now]);        // 현재값 + 다음값
        BS(now+1, sum);                // 현재값 유지
        //이렇게 하면 따로 check 할 필요도 없다.
    }
}
