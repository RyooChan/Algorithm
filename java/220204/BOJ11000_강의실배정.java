import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int course[][] = new int[N][2];
        
        // 0 -> 시작시간, 1 -> 끝시간
        for(int i=0; i<N; i++){
            course[i][0] = sc.nextInt();
            course[i][1] = sc.nextInt();
        }
        
        // 강의를 끝나는 시간에 맞춰 정렬해 준다.
        Arrays.sort(course, new Comparator<int[]>(){
           public int compare(int[] o1, int[] o2){
               if(o1[0] == o2[0]) return (o1[1] - o2[1]);
               else return (o1[0] - o2[0]);
           }
        });
        
        // 필요한 강의실의 개수를 가질 rooms
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        
        // 강의를 시작하고
        for(int i=0; i<N; i++){
            // 사용중인 강의실이 없으면 시작점을 넣어준다.
            if(rooms.isEmpty()){
                rooms.add(course[i][1]);
                continue;
            }
            if(rooms.peek() <= course[i][0]) rooms.remove();    // 지금 강의는 현재 가장 빨리 끝나는 강의보다 늦게 시작된다 -> 그 강의실 사용할거니까 나가게 하기
             rooms.add(course[i][1]);             // 현재 강의를 더해줌.
        }

        System.out.println(rooms.size());
    }
}

// 해설 https://hello-backend.tistory.com/103
