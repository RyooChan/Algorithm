import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        int save = N-K;
        String input = sc.next();
        
        for(int i=0; i<input.length(); i++){
            int now = input.charAt(i) - '0';
            if(st.isEmpty()){
                st.push(now);
            }else{
                while(!st.isEmpty() && K>0){
                    if(st.peek() < now){
                        st.pop();
                        K--;
                    }else break;
                }
                st.push(now);
            }
            if(K<0) break;
        }
        
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop() + "");
        }
        String str = sb.reverse().toString();
        
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<save; i++){
            ans.append(str.charAt(i));
        }
        
        System.out.println(ans);
    }
    
}
