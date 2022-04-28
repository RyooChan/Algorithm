import java.util.*;

public class MyClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        String compare = sc.next();
        
        String first = "";
        String second;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<compare.length(); i++){
            if(compare.charAt(i) != '*') sb.append(compare.charAt(i));
            else{
                first = sb.toString();
                sb.setLength(0); 
            }
        }
        second = sb.toString();
        
        for(int i=0; i<N; i++){
            String str = sc.next();
            if(str.startsWith(first) && str.endsWith(second) && str.length()>=compare.length()) System.out.println("DA");
            else System.out.println("NE");
        }
        
    }
}
