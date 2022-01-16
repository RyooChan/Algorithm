import java.util.*;

public class Main {
    
    public static int N;
    public static boolean[] numbers = new boolean[2000001];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();

        isPrime();

        int ans = 0;
        numbers[1] = true;  // 1은 소수가 아님
        for (int i=N; i<=1004000; i++) {
            if (i < 10 && !numbers[i]) {
                ans = i;
                break;
            } else {
                if (isPelin(i+"") && !numbers[i]) {
                    ans = i;
                    break;
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean isPelin(String num) {
        for(int i=0; i<num.length()/2+1; i++){
            if(num.charAt(i)!=num.charAt(num.length()-1-i)) return false;
        }
        return true;
    }

    public static void isPrime() {
        int num = (int)Math.sqrt(2000000);

        for (int i=2; i<=num; i++) {
            if(!numbers[i]) {
                for (int j=i; i*j<=2000000; j++) {
                    numbers[i*j] = true;
                }
            }
        }
    }
  
}
