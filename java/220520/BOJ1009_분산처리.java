import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(N-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int result = 1;
            for(int i=0; i<b; i++){
                result *= a;
                if(result>=10) result %= 10;
                if(result==0) {
                    result = 10;
                    break;
                }
            }
            sb.append(result + "\n");
        }

         System.out.println(sb);
    }
}
