import java.util.*;

public class Main
{
	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    int destination = sc.nextInt();
    
    int dp[][] = new int[3][N];
    
    List<Info> list = new ArrayList<>();
    
    for(int i=0; i<N; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      int path = sc.nextInt();
      
      // 역주행 불가능
      if(end > destination) continue;
      list.add(new Info(start, end, path));
    }
    
    int distance[] = new int[destination + 1];
    // 그냥 가면 최종 거리는 이렇게 된다.
    Arrays.fill(distance, destination);
    distance[0] = 0;
    
    for(int i=0; i<=destination; i++) {
      // 현재 가장 최소거리는 이전에서 한칸 더 왔을때 혹은 지름길을 통해 왔다면 그 값이 된다.
      if(i>0) distance[i] = Math.min(distance[i], distance[i-1] + 1);
      
      for(int j=0; j<list.size(); j++) {
        Info info = list.get(j);
        int start = info.start;
        int end = info.end;
        int path = info.path;
        
        // 현재 위치가 지름길 시작점이라면
        if(start == i) {
          // 지름길로 도착하는 위치에 가장 빠른 루트를 구한다.
          distance[end] = Math.min(distance[end], distance[start] + path);
        }
      }
    }
    
    System.out.println(distance[destination]);
	}
}

class Info {
  int start;
  int end;
  int path;
  
  Info(int start, int end, int path) {
    this.start = start;
    this.end = end;
    this.path = path;
  }
}
