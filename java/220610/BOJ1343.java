import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            char now = input.charAt(i);
            
            if(cnt==4){
                cnt = 0;
                sb.append("AAAA");
            }
            
            if(now=='X'){
                cnt++;
            }else{
                if(cnt==2){
                    sb.append("BB");
                }else if(cnt%2==1){
                    System.out.println(-1);
                    return;
                }
                sb.append(".");
                cnt = 0;
            }
        }
        if(cnt%2==1){
            System.out.println(-1);
            return;
        }
        if(cnt==2){
            sb.append("BB");
        }else if(cnt==4){
            sb.append("AAAA");
        }
        System.out.println(sb);
    }
}
