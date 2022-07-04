import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        
        while(T-->0){
            int N = sc.nextInt();
            String input = sc.next();
            String comp = sc.next();
            
            int bCnt = 0;
            int wCnt = 0;
            
            int cnt = 0;
            for(int i=0; i<input.length(); i++){
                if(input.charAt(i) != comp.charAt(i)){
                    if(input.charAt(i)=='W') bCnt++;
                    else wCnt++;
                }
            }
            if(bCnt >= wCnt) sb.append(bCnt + "\n");
            else sb.append(wCnt + "\n");
        }
        
        System.out.println(sb);
        
    }
}
