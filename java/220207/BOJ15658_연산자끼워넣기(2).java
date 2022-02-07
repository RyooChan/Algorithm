import java.util.*;

public class MyClass {
    public static int num[];
    public static int oper[];  
    public static int N;
    public static int ansMin = Integer.MAX_VALUE;
    public static int ansMax = Integer.MIN_VALUE;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        num = new int[N];
        oper = new int[4];
        
        for(int i=0; i<N; i++) num[i] = sc.nextInt();
        for(int i=0; i<4; i++) oper[i] = sc.nextInt();
        
        find(1, num[0]);

        System.out.println(ansMax);
        System.out.println(ansMin);
    }
    public static void find(int depth, int nowNum){
        if(depth == N){
            ansMin = Math.min(ansMin, nowNum);
            ansMax = Math.max(ansMax, nowNum);
            return;
        }
        for(int i=0; i<4; i++){
            if(oper[i]==0) continue;
            oper[i]--;
            switch(i){
                case 0 : find(depth+1, nowNum+num[depth]); break;
                case 1 : find(depth+1, nowNum-num[depth]); break;
                case 2 : find(depth+1, nowNum*num[depth]); break;
                case 3 : find(depth+1, nowNum/num[depth]); break;
            }
            oper[i]++;
        }
    }
}
