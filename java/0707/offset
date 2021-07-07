문제
5x5 2차원 배열이 주어질 때 어떤 원소가 상하좌우에 있는 원소보다 작을 때 해당 위치에 * 을 표시하는 프로그램을 작성하시오. 경계선에 있는 수는 상하좌우 중 존재하는 원소만을 비교한다.

 

입력
5x5 행렬의 정보가 25 개의 수로 주어진다. 각 수는 0 에서 9 사이 수이다.

 

출력
*를 포함한 행렬을 출력예의 형식으로 출력한다.

 

예제 입력
copy3 4 1 4 9
2 9 4 5 8
9 0 8 2 1
7 0 2 8 4
2 7 2 1 4
예제 출력
copy3 4 * 4 9 
* 9 4 5 8 
9 0 8 2 * 
7 0 2 8 4 
* 7 2 * 4 

// 풀이
import java.util.Scanner;
public class Main{
    public static int X[] = {-1, 1, 0, 0};
    public static int Y[] = {0, 0, 1, -1};
    public static int num[][] = new int[5][5];
    public static char ans[][] = new char[5][5];
  
    public static void main(String[] args){

       Scanner sc = new Scanner(System.in);
       for(int i=0; i<5; i++){
         for(int j=0; j<5; j++){
           num[i][j] = sc.nextInt();
         }
       }
       
       for(int i=0; i<5; i++){
         for(int j=0; j<5; j++){
           ans[i][j] = find(i, j, num[i][j]);
         }
       }
      
       for(int i=0; i<5; i++){
         for(int j=0; j<5; j++){
           System.out.printf("%c ", ans[i][j]);
         }
         System.out.println();
       }
    }
    public static char find(int Yloc, int Xloc, int now){
      char output = (char)(now + '0'); 
      for(int i=0; i<4; i++){
        if( Xloc + X[i] < 0 || Xloc + X[i] >= 5 || Yloc + Y[i] < 0 || Yloc + Y[i] >= 5 ) continue;
        if( num[Yloc + Y[i]][Xloc + X[i]] <= now ) return output;
        
      }
      return '*';
    }
}
