import java.util.*;

public class Main {
    private static int[] xMove = {1, 1, 1};
    private static int[] yMove = {-1, 0, 1};
    
    private static boolean map[][]; 
    private static int ans = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine(); // 개행을 위해 넣는다.
        
        map = new boolean[R][C];
        
        // 간단하게 장애물 유무를 true/false로 넣는다.
        // true면 뭔가 장애물이 있는겨.
        for(int i=0; i<R; i++) {
          String input = sc.nextLine();
          for(int j=0; j<C; j++) {
            char index = input.charAt(j);
            if (index == '.') {
              map[i][j] = false;
            } else {
              map[i][j] = true;
            }
          }
        }
        
        // 위에서부터 DFS 시작
        for(int i=0; i<R; i++) {
          dfs(0, i);
        }
        
        System.out.println(ans);
    }
    
    private static boolean dfs(int x, int y) {
      for (int i=0; i<3; i++) {
        int xTo = x + xMove[i]; // 얘는 어차피 앞으로만 간다.
        int yTo = y + yMove[i]; // 지금보다 위/직선/아래로 이동한다.
        	// 박스 내에서 움직이기
    		if(xTo<0 || xTo>=map[0].length || yTo<0 || yTo>=map.length) continue;
    		
            // 그래서 그쪽으로 갔을 때에
            // 장애물이 없는 길이라면
    		if(!map[yTo][xTo]) {
              // 이게 목적지라면?
    		  if(xTo == map[0].length - 1) {
    		    ans++; // 답이고
    		    return true; // 이 길이 정답이라고 하고, 더이상의 DFS는 없다.
    		  }
    		  
              // 이길은 지나감(즉 장애물이 된다.)
              // 참고로 이거 다 해줘도 되는 이유는 어차피 여기서 못가면 다른곳에서도 못가기 떄문
              // 여기서 가면 다른곳에서 못가기도 하고
    		  map[yTo][xTo] = true;
    		  if(dfs(xTo, yTo)) return true; // DFS결과 정답이면 정답 루트 색칠
    		}
      }
  		
  		return false;
    }
}
