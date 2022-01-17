import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int D = sc.nextInt();
        int K = sc.nextInt();
        
        int days[][] = new int[D+1][2];
        
        days[1][0] = 1;
        days[1][1] = 0;
        
        days[2][0] = 0;
        days[2][1] = 1;
        
        for(int i=3; i<D+1; i++){
            days[i][0] = days[i-1][0] + days[i-2][0];
            days[i][1] = days[i-1][1] + days[i-2][1];
        }
        
        int oneCnt = days[D][0];
        int twoCnt = days[D][1];
        
        int one=0;
        int two=0;
        
        int sum = 0;
        for(int i=1; i<K; i++){
            for(int j=i; j<K; j++){
                sum = (oneCnt*i) + (twoCnt*j);
                if(sum==K){
                    System.out.println(i);
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}
