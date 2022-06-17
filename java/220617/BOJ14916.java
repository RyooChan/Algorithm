import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int input = sc.nextInt();
        
        int count = 0;
        while(input>0){
            if(input%5==0){
                count += input/5;
                input = 0;
                break;
            }
            input -= 2;
            count++;
        }

        if(input==0){
            System.out.println(count);
        }else{
            System.out.println(-1);
        }

    }
}
