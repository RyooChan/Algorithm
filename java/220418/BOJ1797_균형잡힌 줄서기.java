import java.io.*;
import java.util.*;

class info{
    int gen;
    int loc;

    public info(int gen, int loc) {
        this.gen = gen;
        this.loc = loc;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<info> board = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int gen = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());
            board.add(new info(gen,loc));
        }
        Collections.sort(board, new Comparator<info>() {
            @Override
            public int compare(info o1, info o2) {
                return o1.loc-o2.loc;
            }
        });
        int dp[][] = new int[n+1][2];
        for(int i = 1 ; i <= n ; i++){
            int cur = board.get(i-1).gen;
            dp[i][cur] = dp[i-1][cur]+1;
            if(cur == 0){
                dp[i][1] = dp[i-1][1];
            }else{
                dp[i][0] = dp[i-1][0];
            }

        }

        int genDp[] = new int[n+1];
        for(int i = 0 ; i<= n ; i++){
            genDp[i] = Math.abs(dp[i][0] - dp[i][1]);
        }
        int startEndDp[][] = new int[n+1][2];
        for(int i = 0 ; i <= n ; i++){
            startEndDp[i][0] = -1;
            startEndDp[i][1] = -1;
        }
        for(int i = 0; i <= n ; i++){
            if(startEndDp[genDp[i]][0] == -1){
                if(i == 0)
                    startEndDp[genDp[i]][0] = 0;
                else
                startEndDp[genDp[i]][0] = i-1;
            }else{
                startEndDp[genDp[i]][1] = i-1;
            }
        }
      
        int result = 0;
        for(int i = 0 ; i <= n ; i++){
            if(startEndDp[i][0] != -1 && startEndDp[i][1] != -1){
                if(startEndDp[i][0] == 0)
                    result = Math.max(result, board.get(startEndDp[i][1]).loc-board.get(startEndDp[i][0]).loc);
                else
                result = Math.max(result, board.get(startEndDp[i][1]).loc-board.get(startEndDp[i][0]+1).loc);
            }
        }
        bw.write(result+"");
        bw.close();
    }
}
