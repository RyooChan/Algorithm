import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        int UCPC = 0;
        
        for(int i=0; i<input.length(); i++){
            char now = input.charAt(i);
            if(now=='U' && UCPC==0){
                UCPC=1;
            }else if(now=='C' && UCPC==1){
                UCPC=2;
            }else if(now=='P' && UCPC==2){
                UCPC=3;
            }else if(now=='C' && UCPC==3){
                UCPC=4;
            }
        }
        if(UCPC==4){
            System.out.println("I love UCPC");
        }else{
            System.out.println("I hate UCPC");
        }
        
    }
}
