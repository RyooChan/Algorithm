import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        char board [][] = new char[height][width];
        for(int i = 0 ; i < height ; i++){
            String tmp = br.readLine();
            for(int j = 0 ; j < width ; j++){
                board[i][j] = tmp.charAt(j);
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<>();
        for(int i = 0 ; i < height ; i++){
            StringBuilder sb =new StringBuilder();
            for(int j = 0 ; j < width ; j++){
                if(board[i][j] != '#'){
                    sb.append(board[i][j]);
                    if(j == width-1 && sb.length() > 1){
                        pq.add(sb.toString());
                    }
                }else{
                    if(sb.length() > 1) {
                        pq.add(sb.toString());
                    }
                    sb = new StringBuilder();
                }
            }
        }

        for(int j = 0 ; j < width ; j++){
            StringBuilder sb =new StringBuilder();
            for(int i = 0 ; i < height ; i++){
                if(board[i][j] != '#'){
                    sb.append(board[i][j]);
                    if(i == height-1 && sb.length() > 1){
                        pq.add(sb.toString());
                    }
                }else{
                    if(sb.length() > 1) {
                        pq.add(sb.toString());
                    }
                    sb = new StringBuilder();
                }
            }
        }
        bw.write(pq.poll());
        bw.close();
    }
}
