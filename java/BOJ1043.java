import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[] parent;

    // 지금 이녀석의 맨 위 도착점(기준점) 을 찾는다.
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        // 기준점을 잡으면 그걸로 압축하면서 그 기준점을 return 한다.
        return parent[x] = find(parent[x]);
    }

    // x를 기준으로 두 선의 루트를 맞춰준다.
    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 전체 사람 수
        int M = Integer.parseInt(st.nextToken()); // 파티 수

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i; // 각 사람을 자기 자신을 부모로 초기화
        }

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수

        if (num == 0) {
            System.out.println(M);
            return;
        }

        int[] truth = new int[num];
        for (int i = 0; i < num; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }

        // 전체 파티피플들을 보관
        List<List<Integer>> partyList = new ArrayList<>();

        // 파티 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            // 기준점
            int firstPerson = Integer.parseInt(st.nextToken());
            party.add(firstPerson);

            // 파티에서 만났던 사람들을 묶어준다
            for (int j = 1; j < cnt; j++) {
                int person = Integer.parseInt(st.nextToken());
                party.add(person);
                union(firstPerson, person); // 파티에 속한 사람들끼리 연결
            }
            partyList.add(party);
        }

        // 진실을 아는 사람들을 모두 같은 그룹으로 묶음
        for (int i = 1; i < truth.length; i++) {
            union(truth[0], truth[i]);
        }

        // 거짓말을 할 수 있는 파티 개수 계산
        int ans = 0;
        for (List<Integer> party : partyList) {
            boolean canLie = true;
            for (int person : party) {
                if (find(person) == find(truth[0])) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
