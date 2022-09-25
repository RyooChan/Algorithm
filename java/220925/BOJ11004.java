import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine() , " ");
        int board[] = new int[n];
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(int i =0  ; i < n ; i++){
            board[i] = Integer.parseInt(st.nextToken());
            if(board[i] < left)
                left = board[i];
            if(board[i] > right)
                right = board[i];
        }
        int ans = 0;
        while(left <= right){
            int mid = (left+right)/2;
            int count = 0;
            for(int i = 0 ; i < n ; i++){
                if(board[i] <= mid)
                    count++;
            }
            if(count >= k){
                right = mid-1;
                ans = mid;
            }else{
                left = mid+1;
            }
        }
        bw.write(ans+"");
        bw.close();
    }
}
