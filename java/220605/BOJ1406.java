import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String targetArray = br.readLine();
        
        Stack<Character> stackFront = new Stack<>();
        Stack<Character> stackBack = new Stack<>();
        int iter = targetArray.length();
        
        for(int i = 0 ; i < iter ; i++){
            stackFront.add(targetArray.charAt(i));
        }
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");
            String direction = st.nextToken();
            switch(direction){
                case "L":
                    if(!stackFront.isEmpty()){
                        stackBack.add(stackFront.pop());
                    }
                    break;
                case "D":
                    if(!stackBack.isEmpty()){
                        stackFront.add(stackBack.pop());
                    }
                    break;
                case "B":
                    if(!stackFront.isEmpty()){
                        stackFront.pop();
                    }
                    break;
                case "P":
                    stackFront.add(st.nextToken().charAt(0));
                    break;
            }
        }
        while(!stackFront.isEmpty()){
            stackBack.add(stackFront.pop());
        }
        while(!stackBack.isEmpty()){
            bw.write(stackBack.pop()+"");
        }
        bw.close();
    }
}
