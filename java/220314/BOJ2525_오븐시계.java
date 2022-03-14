import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int h = sc.nextInt();
        int m = sc.nextInt();
        
        int input = sc.nextInt();
        
        int hPlus = input / 60;
        int mPlus = input % 60;
        
        int hOut = (h + hPlus);
        if(m+mPlus>=60) hOut += (m+mPlus)/60;
        hOut %= 24;
        
        int mOut = (m + mPlus)%60;
        
        System.out.println(hOut + " " + mOut);
        

    }
}
