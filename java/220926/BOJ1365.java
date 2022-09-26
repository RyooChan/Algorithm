import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int board[] = new int[n];
        int highNums[] = new int[n]; 
        ArrayList<Integer> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) { 
            board[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if(max < board[i]){
                dp.add(board[i]);
            }else{ 
                int left = 0;
                int right = dp.size()-1;
                while(left<=right){
                    int mid = (left + right)/2;
                    if(dp.get(mid) <= board[i]){ 
                        left = mid+1;
                    }else{
                        right = mid -1;
                    }
                }

                dp.set(right+1 , board[i]);
            }
            max = dp.get(dp.size()-1);
        }
        bw.write(n - dp.size() + "");
        bw.close();
    }
}
