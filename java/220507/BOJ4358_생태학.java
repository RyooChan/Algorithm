import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> hm = new HashMap<>();
        
        int size = 0;
        while(sc.hasNextLine()){
            String input = sc.nextLine();
            hm.put(input, hm.getOrDefault(input, 0) + 1);
            size++;
        }
        
        Object[] mapkey = hm.keySet().toArray();
        Arrays.sort(mapkey);
        
        StringBuilder sb = new StringBuilder();
        
        for(Object a : mapkey){
            String key = a.toString();
            double percent = (double)(hm.get(key)*100.0) / size;
            
            sb.append(key + " " + String.format("%.4f", percent) + "\n");
        }
        System.out.println(sb);
    }
}
