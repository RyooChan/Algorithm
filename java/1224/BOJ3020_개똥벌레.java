import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int H = sc.nextInt();
        
        int haveTo = Integer.MAX_VALUE;
        int haveToCnt = 0;
        
        int up_cnt[] = new int[H+1];
        int un_cnt[] = new int[H+1];
        
        for(int i=0; i<N; i++){
          if(i%2==1) up_cnt[sc.nextInt()]++;
          else un_cnt[sc.nextInt()]++;
        } 
        
        for(int i=H-1; i>0; i--){
            up_cnt[i] += up_cnt[i+1];
            un_cnt[i] += un_cnt[i+1];
        }
        
        for(int i=1; i<H+1; i++){
            int brake = up_cnt[i] + un_cnt[H-i+1];
            if(brake < haveTo){
                haveTo = brake;
                haveToCnt = 1;
            }else if(brake == haveTo) haveToCnt++;
            
        }
        System.out.println(haveTo);
        System.out.println(haveToCnt);
        
    }
}

// 해설 https://hello-backend.tistory.com/94
