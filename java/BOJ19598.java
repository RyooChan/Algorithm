import java.util.*;

public class Main
{

	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<int[]> rooms = new ArrayList<>();
    int N = sc.nextInt();

    for (int i=0; i<N; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();

      // 회의실을 잡고있으면 +1, 나가면 -1
      rooms.add(new int[]{start, 1});
      rooms.add(new int[]{end, -1});
    }

    // 그래서 어떤 곳이던 상관 없이 회의가 시작되면 잡고있고, 나가면 방이 하나 빠지는것이다.
    // 누가 나갔는지는 알바 아니고 그냥 잡고 있는 사람들 중 하나 나가면 나갔다고 해주면 된다.
    // 순서대로 정렬하고 들어오고 나가는데 동시에 이루어진다면 나가는게 우선(그래야 새로운 사람이 들어가니까)
    rooms.sort((a, b) -> {
        if (a[0] == b[0]) return a[1] - b[1];
        return a[0] - b[0];
    });
    
    int ans = 0;
    int roomCnt = 0;

    // 방을 잡고 빼면서 그 최대 갯수만 구해주면 된다.
    for(int i=0; i<rooms.size(); i++) {
      int[] nowRoom = rooms.get(i);
      roomCnt += nowRoom[1];
      
      ans = Math.max(ans, roomCnt);
    }
    System.out.println(ans);
  }
}
