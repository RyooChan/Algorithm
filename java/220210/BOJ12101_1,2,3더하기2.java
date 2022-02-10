import java.util.*;

public class Main {
    public static int n, k;
    public static PriorityQueue<String> nums = new PriorityQueue<>();
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        k = sc.nextInt();

        find(0, "");
        
        if(nums.size() < k){
            System.out.println(-1);
            return;
        } else{
            for(int i=0; i<k-1; i++){
                nums.remove();
            }
            String outData = nums.peek();
            for(int i=0; i<outData.length(); i++){
                System.out.print(outData.charAt(i));
                if(i!=outData.length()-1) System.out.print("+");
            }
        }
    }
    public static void find(int now, String num){
        if(now == n){
            nums.add(num);
            return;
        }else if(now > n){
            return;
        }
        
        find(now+1, num+"1");
        find(now+2, num+"2");
        find(now+3, num+"3");
    }
}
