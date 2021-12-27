import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int Line=in.nextInt();
        if(Line>=1&&Line<=1000) {
            int[][] rank=new int[Line][2];
            int[] money=new int[Line];
            for(int i=0; i<Line; i++) {
                for(int j=0; j<2; j++) {
                    rank[i][j]=in.nextInt();
                }
            }
            for(int i=0; i<Line; i++) {
                if(rank[i][0]>0) {
                    if(rank[i][0]==1) {
                        money[i] +=5000000;
                    }else if(rank[i][0]<=3) {
                        money[i] +=3000000;
                    }else if(rank[i][0]<=6) {
                        money[i] +=2000000;
                    }else if(rank[i][0]<=10) {
                        money[i] +=500000;
                    }else if(rank[i][0]<=15) {
                        money[i] +=300000;
                    }else if(rank[i][0]<=21) {
                        money[i] +=100000;
                    }
                }
            }
            for(int i=0; i<Line; i++) {
                if(rank[i][1]>0) {
                    if(rank[i][1]==1) {
                        money[i] +=5120000;
                    }else if(rank[i][1]<=3) {
                        money[i] +=2560000;
                    }else if(rank[i][1]<=7) {
                        money[i] +=1280000;
                    }else if(rank[i][1]<=15) {
                        money[i] +=640000;
                    }else if(rank[i][1]<=31) {
                        money[i] +=320000;
                    }
                } 
            }    
            for(int i=0; i<Line; i++) {
                System.out.println(money[i]);
            }
        }
    }
}
