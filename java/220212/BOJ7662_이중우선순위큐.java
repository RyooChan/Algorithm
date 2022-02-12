import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            int N = Integer.parseInt(br.readLine());
            
            for(int j=0; j<N; j++){
                String input[] = br.readLine().split(" ");
                String oper = input[0];
                int num = Integer.parseInt(input[1]);
                if(oper.equals("D")){
                    if(tm.isEmpty()) continue;
                    else if(num==1){
                        int minNum = tm.lastKey();
                        int cntNum = tm.get(minNum);
                        if(cntNum == 1) tm.remove(minNum);
                        else tm.put(minNum, cntNum-1);
                    }else{
                        int minNum = tm.firstKey();
                        int cntNum = tm.get(minNum);
                        if(cntNum == 1) tm.remove(minNum);
                        else tm.put(minNum, cntNum-1);
                    }
                }else{
                    tm.put(num, tm.getOrDefault(num, 0)+1);
                }
            }
            if(tm.isEmpty()) System.out.println("EMPTY");
            else System.out.println(tm.lastKey() + " " + tm.firstKey());
        }

    }
}

// https://hello-backend.tistory.com/105
