import java.util.*;

public class Main {
    public static final int maximum = 20001;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        boolean check[][] = new boolean[maximum][maximum];
        Queue<info> imo = new LinkedList<>();
        
        int ans = 99999;
        imo.add(new info(1, 0, 0));
        check[1][0] = true;
        while(!imo.isEmpty()){
            info info = imo.poll();
            int nowCnt = info.nowCnt;
            int copy = info.copy;
            int trial = info.trial;
            // System.out.println("현재숫자 = " + nowCnt + ", 현재클립보드 = " + copy + ", 현재시도횟수 = " + trial);
            
            if(N == nowCnt){
                ans = Math.min(ans, trial); 
                break;
            }
            
            if(nowCnt*2<maximum)imo.add(new info(nowCnt, nowCnt, trial+1)); // 복사하기
            if(nowCnt-1>=0 && !check[nowCnt-1][copy]){
                imo.add(new info(nowCnt-1, copy, trial+1)); // 1빼기
                check[nowCnt-1][copy] = true;
            } 
            if(nowCnt+copy<maximum && !check[nowCnt+copy][copy]){
                imo.add(new info(nowCnt+copy, copy, trial+1));  // 붙여넣기
                check[nowCnt+copy][copy] = true;
            } 
            
        }
        System.out.println(ans);
    }
}
class info{
    int nowCnt;
    int copy;
    int trial;
    info(int nowCnt, int copy, int trial){
        this.nowCnt = nowCnt;
        this.copy = copy;
        this.trial = trial;
    }
}

// 해설 https://hello-backend.tistory.com/91
