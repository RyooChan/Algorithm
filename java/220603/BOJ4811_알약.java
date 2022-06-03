import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        long pills[] = new long[31];
        pills[0] = 1;
        pills[1] = 1;
        pills[2] = 2;
        for(int i=3; i<31; i++){
            for(int j=0; j<i; j++){
                pills[i] += (pills[j] * pills[i-1-j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(sc.hasNext()){
            int N = sc.nextInt();
            if(N==0) break;
            sb.append(pills[N] + "\n");
        }
        System.out.println(sb);
    }
}
