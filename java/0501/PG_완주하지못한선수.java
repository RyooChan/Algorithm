// 완주하지 못한 선수 재풀이
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String i : participant)
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        
        for(String i : completion)
            hm.put(i, hm.get(i) - 1);
        
        Iterator<String> it = hm.keySet().iterator();
        while(it.hasNext()){
            answer = it.next();
            if(hm.get(answer) == 1) break;
        }
        
        return answer;
    }
}
