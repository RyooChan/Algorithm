import java.util.*;

public class Main {
    public static int blue = 0;
    public static int white = 0;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int map[][] = new int[N][N];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }
        color(0, 0, N, map);
        System.out.println(white);
        System.out.println(blue);
    }
    public static void color(int x, int y, int size, int map[][]){
        int nowColor = map[x][y];
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(nowColor != map[i][j]){
                    int toSize = size/2;
                    color(x, y, toSize, map);
                    color(x, y+toSize, toSize, map);
                    color(x+toSize, y, toSize, map);
                    color(x+toSize, y+toSize, toSize, map);
                    return;
                }
            }
        }
        if(nowColor==1) blue++;
        else white++;
        return;
    }
}
