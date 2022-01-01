import java.util.*;
import java.util.Map.*;

class Solution {
    public static int ans = 0;
    public static String friends[] = {"A", "C", "F", "J", "M", "N", "R", "T"};
    
    public int solution(int n, String[] data) {
        int answer = 0;
        ans = 0;
        
        DFS("", data, new boolean[8]);
        
        answer = ans;
        return answer;
    }
    public static void DFS(String loc, String data[], boolean check[]){
        if(loc.length() == 7){
            for(String whoIs : data){
                int one = loc.indexOf(whoIs.charAt(0));
                int two = loc.indexOf(whoIs.charAt(2));
                
                char oper = whoIs.charAt(3);
                int distance = whoIs.charAt(4) - '0' ;
                
                switch(oper){
                    case '>' : if( !(Math.abs(one - two)-1 > distance)  ) return; break;
                    case '=' : if( !(Math.abs(one - two)-1 == distance) ) return; break;
                    case '<' : if( !(Math.abs(one - two)-1 < distance)  ) return; break;
                }
            }
            ans++;
            return;
        }
        for(int i=0; i<8; i++){
            if(!check[i]){
                check[i] = true;

                String friend = loc + friends[i];

                DFS(friend, data, check);
                check[i] = false;
            }
        }
    }
}


// 입력이 좀 이상하게 되어있다... 받을 때 마다 초기화해야함.
