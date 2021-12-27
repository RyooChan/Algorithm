import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int map[][] = new int[N][N];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int l=0; l<N; l++){
                    if(map[j][i]==1 && map[i][l]==1){
                        map[j][l] = 1;
                    }
                }
            }
        }
    
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.printf("%d ", map[i][j]);
            }System.out.println();
        }
    
    }
}
