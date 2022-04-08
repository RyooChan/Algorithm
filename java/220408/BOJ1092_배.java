import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> crane = new ArrayList<>();
        ArrayList<Integer> box = new ArrayList<>();

        int N = sc.nextInt();
        for(int i=0; i<N; i++) crane.add(sc.nextInt());
        Collections.sort(crane, Collections.reverseOrder());

        int M = sc.nextInt();
        for(int i=0; i<M; i++) box.add(sc.nextInt());
        Collections.sort(box, Collections.reverseOrder());
        
        if(crane.get(0) < box.get(0)) System.out.println(-1);
        else{
            int ans = 0;    
            while(!box.isEmpty()){
                int cnt = 0;
                for(int i=0; i<crane.size(); i++){
                    if(box.size() == cnt) break;
                    if(crane.get(i) >= box.get(cnt)) {
                        box.remove(cnt);
                    }else{
                        i--;
                        cnt++;
                    }
                }
                ans++;
            }
            System.out.println(ans);
        }
        
    }
}
