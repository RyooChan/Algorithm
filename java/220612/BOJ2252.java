import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<ArrayList<Integer>> status = new ArrayList<>();
        int indeg[] = new int[n+1];

        for(int i=0; i<n+1; i++){
            status.add(new ArrayList<>());
        }

        for(int i=0; i<k; i++){
            int taller = sc.nextInt();
            int smaller = sc.nextInt();
            status.get(taller).add(smaller);
            indeg[smaller]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i <n+1; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int current = q.poll();
            System.out.println(current);

            for(int i = 0 ; i < status.get(current).size(); i++){
                int next = status.get(current).get(i);
                indeg[next]--;
                if(indeg[next] == 0){
                    q.add(next);
                }
            }
        }
    }
}
