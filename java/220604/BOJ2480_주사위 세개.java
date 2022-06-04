import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int num[] = new int[3];
        
        num[0] = sc.nextInt();
        num[1] = sc.nextInt();
        num[2] = sc.nextInt();
        Arrays.sort(num);
        
        int ans = 0;
        if(num[0]==num[1] && num[1]==num[2]){
            ans += 10000;
            ans += num[0]*1000;
        }else if(num[0]!=num[1]&& num[1]!=num[2]){
            ans += num[2]*100;
        }else{
            ans += 1000;
            ans += num[1]*100;
        }
        System.out.println(ans);
    }
}
