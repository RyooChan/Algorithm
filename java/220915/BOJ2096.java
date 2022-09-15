import java.util.Scanner;

public class Main {
    public static int max(int a ,int b){
        return a > b ? a : b;
    }
    public static int min(int a ,int b){
        return a < b ? a : b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int [][] board = new int [N][3];
        int [][] maxDP = new int [N][3];
        int [][] minDP = new int [N][3];

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < 3 ; j++){
                board[i][j] = sc.nextInt();
                maxDP[i][j] = board[i][j];
                minDP[i][j] = board[i][j];
            }
        }
        for(int i = 1 ; i < N ; i++){
            for(int j = 0 ; j < 3 ; j++) {
                if (j == 0) {
                    maxDP[i][j] = board[i][j] + max(maxDP[i - 1][j], maxDP[i - 1][j + 1]);
                    minDP[i][j] = board[i][j] + min(minDP[i - 1][j], minDP[i - 1][j + 1]);
                } else if (j == 2) {
                    maxDP[i][j] = board[i][j] + max(maxDP[i - 1][j], maxDP[i - 1][j - 1]);
                    minDP[i][j] = board[i][j] + min(minDP[i - 1][j], minDP[i - 1][j - 1]);
                } else{
                    maxDP[i][j] = board[i][j] + max(max(maxDP[i - 1][j], maxDP[i - 1][j - 1]), maxDP[i-1][j+1]);
                    minDP[i][j] = board[i][j] + min(min(minDP[i - 1][j], minDP[i - 1][j - 1]), minDP[i-1][j+1]);
                }
            }
        }
        System.out.print(max(max(maxDP[N - 1][0], maxDP[N - 1][1]), maxDP[N-1][2]) + " ");
        System.out.println(min(min(minDP[N - 1][0], minDP[N - 1][1]), minDP[N-1][2]));
    }
}
