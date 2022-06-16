import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt()+1;
        
        while(N-->0){
            String now = N + "";
            boolean isGold = true;
            for(int i=0; i<now.length(); i++){
                char nowChr = now.charAt(i);
                if(nowChr!='4' && nowChr!='7'){
                    isGold = false;
                    break;
                }
            }
            if(isGold){
                System.out.println(N);
                return;
            }
        }
    }
}
