// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<A.length; i++){
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }

        for(int i : A){
            if(hm.get(i)==1) return i;
        }

        return -1;
    }
}
