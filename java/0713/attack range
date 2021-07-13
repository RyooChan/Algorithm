/*
attackrange
이전다음
문제
윤성이는 어렸을 적부터 수없이 몰려오는 적으로부터 기지를 방어하는 디펜스 유형의 게임을 플레이하는 것을 좋아했다. 그래서 간단한 디펜스 게임을 만들어 보려고 한다.

당신은 윤성이를 도와, 디펜스 게임 내에서 플레이어가 설치하는 유닛의 사거리를 나타내는 기능을 구현하면 된다.  

입력
입력 첫째 줄에는 디펜스 게임의 맵 크기 N이 주어딘다. 맵은 N×N 크기의 2차원 형태이다. (N은 6이상 100이하의 짝수)

둘째 줄에는 유닛이 설치될 위치 X, Y와 유닛의 사거리 R이 주어진다. X는 행의 번호, Y는 열의 번호를 의미한다. (X, Y는 1이상 N이하의 자연수, R은 N/2이하의 자연수)

 

출력
예제 출력과 같이 유닛의 사거리를 나타내어 출력한다. (유닛의 사거리가 아무리 길어도 맵을 벗어날 수는 없다.)

 

예제 입력
copy8
4 5 3
예제 출력
copy0 0 0 0 3 0 0 0
0 0 0 3 2 3 0 0
0 0 3 2 1 2 3 0
0 3 2 1 x 1 2 3
0 0 3 2 1 2 3 0
0 0 0 3 2 3 0 0
0 0 0 0 3 0 0 0
0 0 0 0 0 0 0 0
 

예제 입력
copy6
2 3 3
예제 출력
copy3 2 1 2 3 0
2 1 x 1 2 3
3 2 1 2 3 0
0 3 2 3 0 0
0 0 3 0 0 0
0 0 0 0 0 0
*/

// 풀이
import java.util.*;
public class Main{
    public static void main(String[] args){

       // Please Enter Your Code Here
        Scanner sc = new Scanner(System.in);
        
        int N =sc.nextInt();
        
        String[][] map = new String[N][N];
        
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int R = sc.nextInt();
        
//        R += 49;
        for(int i = 0 ; i < map.length; i++){
            for(int j = 0 ; j < map[i].length; j++){
              map[i][j] = "0";
            }
          }
        
        map[X-1][Y-1] = "x";
         
         int Xtemp = X;
       // y 축만
         // Y축 위로
       int Y_UP_start = 1;
       while((X-1) > 0 && (int)Y_UP_start <= (int)R ){
         X--;
         map[X-1][Y-1] = Integer.toString(Y_UP_start);
         Y_UP_start++;
       }
       
       //X 값 다시 초기화 처음으로
       X = Xtemp;
         // Y축 아래로
       int Y_DOWN_start = 1;
       while((X-1) < map.length-1 && (int)Y_DOWN_start <= (int)R){
         X++;
         map[X-1][Y-1] = Integer.toString(Y_DOWN_start);
         Y_DOWN_start++;
       }
       // x 기준으로 우측 
       X = Xtemp;
       int Ytemp = Y;
       int X_RIGHT_start = 1;
       int X_RIGHT_Y_DOWN_start = 0;
       int X_RIGHT_Y_UP_start = 0;
       int maxY = map.length-1;
       while((Y-1) < map.length -1 && (int)X_RIGHT_start <= (int)R  ) {
    	   Y++;
    	   map[X-1][Y-1] = Integer.toString(X_RIGHT_start);
    	   
    	   // X축 기준으로 우측 가서 위로
    	   X_RIGHT_Y_DOWN_start = X_RIGHT_start;
    	   X_RIGHT_Y_DOWN_start++;
    	   while((X-1) < maxY && (int)X_RIGHT_Y_DOWN_start <= (int)R) {
    		   X++;
    		   map[X-1][Y-1] = Integer.toString(X_RIGHT_Y_DOWN_start);
    		   X_RIGHT_Y_DOWN_start++;
    	   }
    	   X = Xtemp;
    	   X_RIGHT_Y_UP_start = X_RIGHT_start;
    	   X_RIGHT_Y_UP_start++;
    	   while((X-1) > 0 && (int)X_RIGHT_Y_UP_start <= (int)R ) {
    		   X--;
    		   map[X-1][Y-1] = Integer.toString(X_RIGHT_Y_UP_start);
    		   X_RIGHT_Y_UP_start++;
    	   }
    		   
    		   
    	   X = Xtemp;
    	   X_RIGHT_start++;
    	   
    	   
//    	   while((X-1) < 0)
       }
       Y = Ytemp;
       int X_LEFT_start = 1;
       int X_LEFT_Y_DOWN_start = 0;
       int X_LEFT_Y_UP_start = 0;
       while((Y-1) > 0 && (int)X_LEFT_start <= (int)R) {
    	   Y--;
    	   map[X-1][Y-1] = Integer.toString(X_LEFT_start);
    	   X_LEFT_Y_DOWN_start = X_LEFT_start;
    	   X_LEFT_Y_DOWN_start++;
    	   while((X-1) < maxY && (int)X_LEFT_Y_DOWN_start <= (int)R) {
    		   X++;
    		   map[X-1][Y-1] = Integer.toString(X_LEFT_Y_DOWN_start);
    		   X_LEFT_Y_DOWN_start++;
    	   }
    	   X = Xtemp;
    	   X_LEFT_Y_UP_start = X_LEFT_start;
    	   X_LEFT_Y_UP_start++;
    	   while((X-1) > 0 && (int)X_LEFT_Y_UP_start <= (int)R) {
    		   X--;
    		   map[X-1][Y-1] = Integer.toString(X_LEFT_Y_UP_start);
    		   X_LEFT_Y_UP_start++;
    	   }
    	   
    	   X = Xtemp;
    	   X_LEFT_start++;
       }
       
       
       for(int i = 0 ; i < map.length; i++) {
    	   for(int j = 0 ; j < map[i].length;j++) {
    		   System.out.print(map[i][j] + " ");
    	   }
    	   System.out.println();
       }
      
    }
}
