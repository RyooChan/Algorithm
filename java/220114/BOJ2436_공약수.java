import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        long GCD = sc.nextInt();
        long LCM = sc.nextInt();
        long mul = GCD * LCM;
        
        long A=GCD;
        long B=LCM;
        
        long sumMax = 2000000000;
        
        for(long i=GCD; i*i<=mul; i += GCD){
            long other = mul/i;     // 
            if(mul%i!=0) continue;
            if(GCD == getGCD(other, i)){
                long sum = i+other;
                if(sumMax > sum){
                    sumMax = sum;
                    A = i;
                    B = other;
                }
            }
        }
        System.out.println(A + " " + B);
        
    }
    // 유클리드 호제법 사용하기
    public static long getGCD(long num1, long num2){
        long n = num1 % num2;
        if(n==0) return num2;
        else return getGCD(num2, n);
    }
}
