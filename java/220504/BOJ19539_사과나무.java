import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int height[] = new int[N];
        int sum = 0;
        int water_two = 0;
        for(int i=0; i<N; i++){
            height[i] = sc.nextInt();
            sum += height[i];
            water_two += height[i]/2;
        } 
        
        if(sum/3<=water_two && sum%3==0){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
