import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        long x = sc.nextLong();
        long y = sc.nextLong();
        
        long sum = x + y;
        long lastNum = 1;
        while(true){
            if( sum < (lastNum+1)*lastNum/2 ){
                System.out.println(-1);
                return;
            }else if( sum == (lastNum+1)*lastNum/2 ){
                break;
            }else{
                lastNum++;
            }
        }
        
        int cnt = 0;
        while(x>0){
            x -= lastNum--;
            cnt++;
        }
        System.out.println(cnt);
    }
}

// <script src="https://gist.github.com/RyooChan/3280981929596e56d920363b6ebd14f9.js"></script>
