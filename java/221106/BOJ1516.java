import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }
        int[] indegree = new int[N + 1]; 
        int[] times = new int[N + 1]; 

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            times[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int num = Integer.parseInt(st.nextToken());

                if (num == -1) {
                    break;
                }
                a.get(num).add(i);
                indegree[i]++;
            }
        }

        String ans = topologicalSort(a, indegree, times, N);
        bw.write(ans + "\n");
        bw.close();
    }

    public static String topologicalSort(ArrayList<ArrayList<Integer>> a, int[] indegree, int[] times, int N) {
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] result = new int[N + 1];

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : a.get(now)) {
                indegree[next]--;

                result[next] = Math.max(result[next], result[now] + times[now]);

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append((result[i] + times[i]) + "\n");
        }

        return sb.toString();
    }
}
