import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Stack<Character> st = new Stack<>();
		String input = sc.nextLine();
		int ans = 0;
		int num = 1;
		char before;
		
		for(int i=0; i<input.length(); i++) {
			char now = input.charAt(i);
			if(now == '(') {
				st.push(now);
				num *= 2;
			}
			else if(now == '[') {
				st.push(now);
				num *= 3;
			}
			else if(now == ']') {
				if(st.empty() || st.peek() != '[') {
					ans = 0;
					break;
				}
				before = st.pop();
				if(input.charAt(i-1) == '[')
					ans += num;
				num /= 3;
				
			}
			else if(now == ')'){
				if(st.empty() || st.peek() != '(') {
					ans = 0;
					break;
				}

				before = st.pop();
				if(input.charAt(i-1) == '(')
					ans += num;
				num /= 2;
				
			}
		}
        if(!st.empty()) ans = 0;
        
		System.out.println(ans);
		
		
	}
}
