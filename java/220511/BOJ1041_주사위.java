import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long dice[] = new long[6];
        long two = Long.MAX_VALUE;
        long one = Integer.MAX_VALUE;
        
        for(int i=0; i<6; i++){
            dice[i] = sc.nextInt();
            one = Math.min(one, dice[i]);
        } 
        
        if(N==1) {
            int ans = 0;
            Arrays.sort(dice);
            for(int i=0; i<5; i++) ans += dice[i];
            System.out.println(ans);
            return;
        }
        
        long threeEyes = 4;
        long twoEyes = (N-2)*8 + 4;
        long oneEye = 5*(N-2)*(N-2) + 4*(N-2);
        
        // a-f / b-e / c-d 제외 최소 05 14 23 -> 5
        for(int i=0; i<6; i++){
			for (int j = i+1; j<6; j++) {
				if (j+i != 5) {
					two = Math.min(two, (dice[i]+dice[j]));
				}
			}
        }
        
        long three = 0;
		for (int i=0; i<3; i++) {
			three += Math.min(dice[i], dice[5 - i]);
		}
        
        long ans = 0;
        ans += one * oneEye;
        ans += two * twoEyes;
        ans += three * threeEyes;

        System.out.println(ans);
    }
}B
