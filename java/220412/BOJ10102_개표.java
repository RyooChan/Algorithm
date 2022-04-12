import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        sc.next();
        String input = sc.next();
    
        int a = 0;
        int b = 0;
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) == 'A') a++;
            else b++;
        }

        if(a>b) System.out.println("A");
        else if(a<b) System.out.println("B");
        else System.out.println("Tie");
    }
}
