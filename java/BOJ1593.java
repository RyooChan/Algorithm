import java.util.*;

public class Main
{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        sc.nextLine();
        
        String W = sc.nextLine();
        String S = sc.nextLine();
        
        int wLength = W.length();
        int ans = 0;
        
        int wArr[] = new int[52];
        int sArr[] = new int[52];
        
        for(int i=0; i<wLength; i++) {
            char index = W.charAt(i);
            addArr(index, 1, wArr);
        }
        
        for(int i=0; i<S.length(); i++) {
            char index = S.charAt(i);
            
            if (i >= wLength) {
                addArr(S.charAt(i - wLength), -1, sArr);
            } 
            
            addArr(index, 1, sArr);
            
			if(Arrays.equals(wArr, sArr)) {
				ans++;
			}
        }
        
        System.out.println(ans);
    }
    
    private static void addArr(char index, int inOut, int[] arr) {
        if (index >= 'a') {
            arr[index - 'a'] += inOut;
        } else {
            arr[index - 'A' + 26] += inOut;
        }
    }
}
