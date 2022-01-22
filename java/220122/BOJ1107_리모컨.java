import java.util.*;

public class Main {
    public static boolean button[] = new boolean[10];
    public static int channer;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        channer = sc.nextInt();
        
        int N = sc.nextInt();
        
        for(int i=0; i<N; i++) button[sc.nextInt()] = true;
        
        int ans = Math.abs(channer-100);    // +/-버튼만을 이용하여 원하는 채널로 이동하는 방법
        for(int i=0; i<=999999; i++){       // 0번 채널로부터 999999채널로 시작점을 설정한다.
            String nowChanner = i+"";       // 현재 채널
            boolean can = true;             // 현재 채널을 만들 수 있나?(고장난 숫자버튼이 없는가?)
            for(int j=0; j<nowChanner.length(); j++){   // 현재 채널의 모든 숫자들에 대해
                int nowButton = nowChanner.charAt(j) - '0';   // 현재 채널을 이루는 숫자
                if(button[nowButton]){    // 지금 숫자가 고장났다 -> 갈 수 없다.
                    can = false;       
                    break;
                }
            }
            if(can){      // can이 true라면, 숫자를 통해 현재 i값, 즉 현재 채널로 갈 수 있다는 것이다.
                int click = nowChanner.length() + Math.abs(channer-i);    // 클릭 수 = 현재채널로 갈 때 클릭한 숫자수 + 현재채널로부터 원하는채널로 이동하는 횟수
                ans = Math.min(ans, click); 
            }
        }
        System.out.println(ans);        
    }
}

// 해설 https://hello-backend.tistory.com/100
