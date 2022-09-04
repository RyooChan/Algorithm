import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int []dx = {1,0,0,-1};
    static int []dy = {0,1,-1,0};
    static int n;
    static char [][]arr;
    static Boolean [][]visit;
    static int result;
    static int result2;
    public static class Pair {
        int x,y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visit = new Boolean[n][n];
        result = -1;
        result2 = 987654321;
        for(int i=0;i<n;i++)
        Arrays.fill(visit[i], false);
        for(int i=0;i<n;i++)
            arr[i] = br.readLine().toCharArray();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                bfs(j,i);
        }
        bw.write(Integer.toString(result) +" "+ Integer.toString(result2));
        bw.flush();
    }

    static void bfs(int x, int y)
    {
        if (visit[y][x] || arr[y][x] != '#')
            return ;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        visit[y][x] = true;
        int res = 1;
        int res2 =0 ;
        while (!queue.isEmpty()) {
            int curx = queue.peek().x;
            int cury= queue.peek().y;
            queue.poll();
            int cnt = 4;
            for (int i = 0; i < 4; i++) {
                int nx = curx+ dx[i];
                int ny = cury + dy[i];
                if(nx >=0 && ny >=0 && nx < n && ny < n && arr[ny][nx] == '#')
                    cnt--;
                if (nx >=0 && ny >=0 && nx < n && ny < n && !visit[ny][nx] && arr[ny][nx] =='#') {
                    queue.add(new Pair(nx, ny));
                    visit[ny][nx] = true;
                    res++;
                }
            }
            res2 += cnt;
        }
        if (result < res)
        {
            result = res;
            result2 = res2;
        }
        else if (result == res)
            result2 = Math.min(res2,result2);
    }

}
