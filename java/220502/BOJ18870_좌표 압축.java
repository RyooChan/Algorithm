import java.util.*;

public class MyClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int num[] = new int[N];
        
        for(int i=0; i<N; i++){
            num[i] = sc.nextInt();
        }
        
        int ans[] = num.clone();
        
        Arrays.sort(num);
        
   	 	HashMap<Integer, Integer> hm = new HashMap<>();
   	 	int cnt = 0;
   	 	for(int i=0; i <N; i++) {
   	 		if(!hm.containsKey(num[i]))	hm.put(num[i], cnt++);
   	 	}
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) sb.append(hm.get(ans[i])).append(" ");
        
        System.out.println(sb);

    }
}

// 어렵다.. 실2 
