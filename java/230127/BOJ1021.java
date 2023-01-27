import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> q = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++){
            q.add(i);
        }
        int targetArr[] = new int[m];
        st = new StringTokenizer(br.readLine() , " ");
        for(int i = 0 ; i < m ; i++){
            targetArr[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        for(int i = 0 ; i < m ; i++){
            int index = 0;
            int dirA = 0;
            while(true){
                if(targetArr[i] == q.get(index)){
                    dirA = index;
                    break;
                }
                index++;
            }
            int dirB = q.size() - index;
            if(dirA>dirB){
                while(true){
                    int tmp = q.remove(0);
                    if(tmp == targetArr[i])
                        break;
                    q.add(tmp);
                }
            }else{
                while(true){
                    int tmp = q.remove(q.size()-1);
                    if(tmp == targetArr[i])
                        break;
                    q.add(0 , tmp);
                }
            }
            result += Math.min(dirA, dirB);
        }
        bw.write(result+"");
        bw.close();
    }
}
