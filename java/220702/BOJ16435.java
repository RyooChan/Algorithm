 java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int length = sc.nextInt();
        
        int num[] = new int[N];
        
        for(int i=0; i<N; i++) num[i] = sc.nextInt();
        Arrays.sort(num);
        
        int cnt = 0;
        for(int i=0; i<N; i++){
            if(length >= num[i]){
                length++;
            }else{
                break;
            }
        }
        System.out.println(length);
        
    }
}