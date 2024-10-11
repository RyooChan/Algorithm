/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = Integer.parseInt(sc.nextLine());
        
        while(T-->0) {
            
            int ans = 0;
            String input = sc.nextLine();
            
            int[] intArray = Arrays.stream(input.split(" "))
                                   .mapToInt(Integer::parseInt)
                                   .toArray();
                                   
            int houseCnt = intArray[0];
            int moneyCnt = intArray[1];
            int moneyMax = intArray[2] - 1;
        
            input = sc.nextLine();
            
            int[] houseArr = Arrays.stream(input.split(" "))
                                   .mapToInt(Integer::parseInt)
                                   .toArray();
                                   
            long money = 0;
            
            if (houseCnt == moneyCnt) {
                for (int i = 0; i < houseCnt; i++) {
                    money += houseArr[i];
                }
                if (money <= moneyMax) {
                  System.out.println(1);
                  continue;
                }
            }
            
            for(int i=0; i<houseCnt + moneyCnt - 1; i++) {
                if(i >= moneyCnt) {
                    money -= houseArr[i - moneyCnt];
                }
                
                money += houseArr[i % houseCnt];
                
                if (i >= moneyCnt - 1 && money <= moneyMax) {
                    ans++;
                }
            }
            
            System.out.println(ans);
        }
    }
}
