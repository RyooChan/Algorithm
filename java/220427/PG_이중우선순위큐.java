import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int ans[] = new int[2];
        
        for(String inputs : operations){
            String input[] = inputs.split(" ");
            String oper = input[0];
            int num = Integer.parseInt(input[1]);
            
            if(oper.equals("D")){
                if(tm.isEmpty()) continue;
                else if(num==1){      // 큰 수를 삭제하는 경우
                    int minNum = tm.lastKey();    // 제일 작은 수를 가져오고
                    int cntNum = tm.get(minNum);  // 그 수가 몇개 있는지 확인하여
                    if(cntNum == 1) tm.remove(minNum);  // 1개만 있으면 그냥 지우고
                    else tm.put(minNum, cntNum-1);      // 그보다 많으면 숫자를 하나 줄여준다.
                }else{              // 작은수도 로직은 똑같다.
                    int minNum = tm.firstKey();
                    int cntNum = tm.get(minNum);
                    if(cntNum == 1) tm.remove(minNum);
                    else tm.put(minNum, cntNum-1);
                }
            }else{
                tm.put(num, tm.getOrDefault(num, 0)+1);   // 현재 수를 입력하고, 없으면 생성, 있으면 cnt늘리기
            }
        }
        if(!tm.isEmpty()){
            ans[0] = tm.lastKey();
            ans[1] = tm.firstKey();
        }
        return ans;
    }
}
