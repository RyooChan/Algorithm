import java.util.*;

public class Main {
    public static int N;
    public static int ans = Integer.MIN_VALUE;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> energy = new ArrayList<>();
        
        N = sc.nextInt();
        
        for(int i=0; i<N; i++) energy.add(sc.nextInt());
        
        find(0, energy);

        System.out.println(ans);
    }
    public static void find(int num, ArrayList<Integer> energy){
        if(energy.size() <= 2 ){
            ans = Math.max(ans, num);
            return;
        } 
        for(int i=1; i<energy.size()-1; i++){
            int nowNum = energy.get(i);
            int makeNum = energy.get(i-1) * energy.get(i+1);
            energy.remove(i);
            find(num + makeNum, energy);
            energy.add(i, nowNum);
        }
        
    }
}
