/*
문제
체스에서 룩이라는 기물은 막혀있지만 않으면 룩의 위치에서 같은 행, 같은 열에 해당하는 칸 중 하나로 한 번 이동할 수 있다. 단, 특정 칸이 막혀있다면 그 칸에서부터 더 나아갈 수는 없다. 만약 룩이 아래 그림과 같이 5행 4열에 존재하고 같은 행열에 기물이 없다면 5행이나 4열에 존재하는 칸 중 어디로든 갈 수 있다. 예를 들어, 5행 2열 혹은 1행 4열로 움직일 수 있다. 차례에 주어진 이동 횟수는 한 번이므로 이동이 완료되었다면 상대방의 차례로 넘어간다.

alt text

체스는 킹만 잡히면 지게 되는 게임이다. 그 중에서도 알랩이는 룩으로 인해 게임을 지는 것을 극도로 싫어한다!

주어진 체스판의 상태에서 현재 차례가 상대의 차례일 때, 이번 차례에 알랩이의 킹이 상대방의 룩에게 잡힐 가능성이 있는지 알아보자.

 

입력
8줄에 걸쳐 8x8 체스판의 상태가 주어진다. 이때 0은 기물이 없는 상태이고, 1은 알랩이의 킹을 의미하고, 2는 상대의 룩을 의미하며 3은 그 외 다른 기물들을 의미한다. (킹은 하나만 존재하며, 상대의 룩은 최대 2개까지 있을 수 있다. 그 외 기물들은 최대 29개까지 있을 수 있다.)

 

출력
킹이 룩에게 잡힐 가능성이 있으면 1, 아니면 0을 출력한다.

 

예제 입력 1
copy0 3 0 0 0 0 0 0
3 1 0 0 0 0 2 0
0 3 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
예제 출력 1
copy1
 

예제 입력 2
copy0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 3 3 0 0 0 0 0
3 0 1 0 3 0 2 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
예제 출력 2
copy0
*/

// 풀이
import java.util.Scanner;
public class Main{
    public static int board[][] = new int[8][8];
    public static int kingX;
    public static int kingY;
    public static boolean locCheck[] = new boolean[4];
    public static boolean process = false;
    public static int ans = 0;
    
    public static void main(String[] args){

       Scanner sc = new Scanner(System.in);
       // 킹위치 기준 상 하 좌 우로 진행하기 위해 변수 4가지 선언
       int Xminus = 0;
       int Xplus = 0;
       int Yminus = 0;
       int Yplus = 0;
       
       for(int i=0; i<8; i++){
         for(int j=0; j<8; j++){
           int input = sc.nextInt();
           board[i][j] = input;
           if(input == 1){  // 킹의 경우 해당 위치를 파악한다.
             kingX = i;
             kingY = j;
           }
         }
       }
       
       while(!process){ // process는 상하좌우 모두 탐색이 끝났거나 룩에게 잡힐수 있는 경우 true가 되며 그 때 while문을 돌지 않는다.
         process = (locCheck[0] && locCheck[1] && locCheck[2] && locCheck[3]); // 모두 탐색이 끝나면 true
         if(!locCheck[0]) {   // 왼쪽으로 가면서 진행
           Xminus++;
           check(kingX-Xminus, kingY, 0); // check의 3번째 인자가 0이면 왼쪽이다. 
         }
         if(!locCheck[1]){
           Xplus++;
            check(kingX+Xplus, kingY, 1);
         }
         if(!locCheck[2]) {
           Yminus++;
           check(kingX, kingY-Yminus, 2);
         }
         if(!locCheck[3]){
           Yplus++;
            check(kingX, kingY+Yplus, 3);
         }//쭉쭉 진행해준다.
       }
       
       System.out.println(ans);
    }
    public static void check(int X, int Y, int loc){    // X축, Y축, (0/1/2/3)->(좌/우/하/상)
      if(X<0 || Y<0 || X>=8 || Y>=8 ){    // 체스판 밖으로 나갈것같으면 더이상 진행하지 않도록 해당 loc을 true로 해준다.
        locCheck[loc] = true;
        return;
      }
      else if(board[X][Y] == 3){      // 체스판 내에서 기물을 만날 경우 더이상 진행하지 않도록 해당 loc을 true로 해준다.
        locCheck[loc] = true;
        return;
      }
      else if( board[X][Y] == 2 ){    // 체스판 내에서 기물이 없이 룩을 만나면 ans를 1로 하고, 더이상 진행하지 않도록 process를 true로 해준다.
        process = true;
        ans = 1;
        return;
      }
      return;
    }
}
