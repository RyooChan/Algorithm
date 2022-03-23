import java.util.*;

public class Main {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> hs = new HashSet<>();
        
        String input = sc.next();
        
        for(int i=0; i<input.length(); i++){
            String make = "";
            for(int j=i; j<input.length(); j++){
                make += input.substring(j, j+1);
                hs.add(make);
            }
        } 
        System.out.println(hs.size());
    }
}
