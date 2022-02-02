import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        String input = sc.next();
        int map[] = new int[input.length()+1];
        for(int i=1; i<input.length()+1; i++){
            map[i] = changer(input.charAt(i-1));
        }
        
        int jump[] = new int[N+1];
        for(int i=2; i<N+1; i++){
            for(int j=1; j<i; j++){
                if( map[i]==map[i-j]+1 || (map[i]==0 && map[i-j]==2) ){
                    if( jump[i-j]==0 && (i-j)!=1 ) continue;
                    if(jump[i]!=0) jump[i] = Math.min( jump[i], jump[i-j]+(int)Math.pow(j, 2) );
                    else jump[i] = jump[i-j]+(int)Math.pow(j, 2) ;
                }
            }
        }
        if(jump[N]==0) jump[N] = -1;
        System.out.println(jump[N]);
        
    }
    public static int changer(char in){
        switch(in){
            case 'B' : return 0;
            case 'O' : return 1;
            default  : return 2;
        }
        
    }
}
