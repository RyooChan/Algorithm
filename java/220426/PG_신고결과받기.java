import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> reportCnt = new HashMap<>();
        Map<String, HashSet<String>> reporter = new HashMap<>();
 
        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            reporter.put(name, new HashSet<>());
            reportCnt.put(name, i);
        }
 
        for (String s : report) {
            String[] str = s.split(" ");
            String from = str[0];
            String to = str[1];
            reporter.get(to).add(from);
        }
 
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> send = reporter.get(id_list[i]);
            if (send.size() >= k) {
                for (String name : send) {
                    answer[reportCnt.get(name)]++;
                }
            }
        }
        return answer;
    }
}
