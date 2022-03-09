import java.util.*;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> hm = new HashMap<>();
        
        int N = sc.nextInt();
        
        for(int i=0; i<N; i++){
            hm.put(sc.next(), i);
        }
        
        int out[] = new int[N];
        
        for(int i=0; i<N; i++){
            out[i] = hm.get(sc.next());
        }
        
        int ans = 0;
        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                if(out[i] > out[j]){
                    ans++;
                    break;
                }
            }
        }
		System.out.println(ans);
        
    }
}
