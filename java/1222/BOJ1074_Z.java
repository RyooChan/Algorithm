import java.util.*;

public class Main {
    public static int ans = 0;
    
    public static void main(String args[]) {
        Scanner sc =  new Scanner(System.in);
        
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        
        find(r, c, (int)Math.pow(2, N));
        System.out.println(ans);
    }
    public static void find(int r, int c, int frame){
        if(frame==1) return;
        
        if(r<frame/2 && c<frame/2){
            find(r, c, frame/2);
        }else if(r<frame/2 && c>=frame/2){
            ans += ( (int)Math.pow(frame, 2)/4 );
            find(r, c-frame/2, frame/2);
        }else if(r>=frame/2 && c<frame/2){
            ans += ( (int)Math.pow(frame, 2)/4 )*2;
            find(r-frame/2, c, frame/2);
        }else{
            ans += ( (int)Math.pow(frame, 2)/4 )*3;
            find(r-frame/2, c-frame/2, frame/2);
        }
    }
    
}

// 해설 https://hello-backend.tistory.com/93
