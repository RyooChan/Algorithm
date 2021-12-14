/*
단지번호붙이기 성공출처분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	79812	32652	20672	39.090%
문제
<그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.



입력
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

출력
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

예제 입력 1 
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
예제 출력 1 
3
7
8
9
*/

// 풀이
import java.util.*;

public class Main{
    static public char[][] house;
    
    // 현재 위치 기준 위, 아래, 오른쪽, 왼쪽을 찾기 위한 x y 값들이다.
    static public int[] x = {-1,0,1,0};
    static public int[] y = {0,1,0,-1};
    
    // 한번 찾은 장소를 체크한다.
    static public int[][] check;
    // 찾은 아파트 값
    static public int cnt =0;
    static public int N;
    // 단지별 값들이다.
    static public ArrayList<Integer> houseNum = new ArrayList<Integer>();
    public static void main(String[] args){
        // ----------- 입력 ------------------------------------
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        house = new char[N][N];
        check = new int[N][N];
        String temp;
 
        for(int i=0; i<N; i++){
            temp = sc.nextLine();
            for(int j=0; j<N; j++){
                house[i][j] = temp.charAt(j);
            }
        }
        //-----------------------------------------------------------------
 
        for(int i=0; i<N ; i++){
            for(int j=0; j<N; j++){
                // 현재 위치에 아파트가 존재하고, 방문하지 않은 장소일 때
                if(house[i][j] =='1' && check[i][j] == 0){
                    // 아파트의 개수를 늘려주고 방문했다는 표시를 해준 뒤 dfs를 진행한다.
                    cnt = 1;
                    check[i][j] = 1;
                    dfs(i,j);
                    houseNum.add(cnt);
                }
                    
            }
        }
 
        Collections.sort(houseNum);
 
        System.out.println(houseNum.size());
        for(int i=0; i<houseNum.size(); i++){
            System.out.println(houseNum.get(i));
        }
 
 
    }
    
 
    static public void dfs(int i, int j){
        // 상하좌우를 확인한다.
        for(int k=0; k<4; k++){
            int ni = i + x[k];
            int nj = j + y[k];
            // 그리고 해당 상하좌우가 배열을 벗어나지 않았을 때
            if(ni>=0 && ni<N && nj >=0 && nj<N){
                // 추가로 그 위치를 방문하지 않았을 때
                if(check[ni][nj]==0 && house[ni][nj] == '1'){
                    // 확인시켜 주고 단지수를 늘려준다.
                    check[ni][nj] = 1;
                    cnt++;
                    // 다시 상하좌우를 dfs를 돌려주면 나의 위치 기준으로 다른 아파트가 있는지 확인 가능하다.
                    dfs(ni, nj);
                }
            }
        }
 
    }
}
