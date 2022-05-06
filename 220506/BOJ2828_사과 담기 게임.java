import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int num = sc.nextInt();
        
        int move = 0;
        int left = 0;
        int right = M-1;
        
        for(int i=0; i<num; i++){
            int loc = sc.nextInt()-1;
            if(loc > right){
                move += (loc-right);
                right = loc;
                left = loc - M + 1;
            }else if(loc < left){
                move += (left-loc);
                left = loc;
                right = loc + M - 1;
            }
        }

        System.out.println(move);
    }
}
