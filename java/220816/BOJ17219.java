import java.util.*;

public class Main
{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> hm = new HashMap<>();
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        for(int i=0; i<N; i++){
            hm.put(sc.next(), sc.next());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            sb.append(hm.get(sc.next()) + "\n");
        }
        System.out.println(sb.toString());
	}
}
