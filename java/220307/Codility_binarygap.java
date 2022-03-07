// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        
        String toBinary = Integer.toBinaryString(N);

        char binaries[] = toBinary.toCharArray();
        
        int cnt = 0;
        int gap = 0;
        for(char c : binaries){
            if(c=='0') cnt++;
            else{
                gap = Math.max(cnt, gap);
                cnt = 0;
            }
        }

        return gap;

    }
}
