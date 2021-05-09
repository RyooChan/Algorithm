/*
멀티탭 스케줄링 출처분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	12137	3026	2293	25.886%
문제
기숙사에서 살고 있는 준규는 한 개의 멀티탭을 이용하고 있다. 준규는 키보드, 헤어드라이기, 핸드폰 충전기, 디지털 카메라 충전기 등 여러 개의 전기용품을 사용하면서 어쩔 수 없이 각종 전기용품의 

를 뺐다 꽂았다 하는 불편함을 겪고 있다. 그래서 준규는 자신의 생활 패턴을 분석하여, 자기가 사용하고 있는 전기용품의 사용순서를 알아내었고, 이를 기반으로 플러그를 빼는 횟수를 최소화하는 방법을 고안하여 보다 쾌적한 생활환경을 만들려고 한다.

예를 들어 3 구(구멍이 세 개 달린) 멀티탭을 쓸 때, 전기용품의 사용 순서가 아래와 같이 주어진다면, 

키보드
헤어드라이기
핸드폰 충전기
디지털 카메라 충전기
키보드
헤어드라이기
키보드, 헤어드라이기, 핸드폰 충전기의 플러그를 순서대로 멀티탭에 꽂은 다음 디지털 카메라 충전기 플러그를 꽂기 전에 핸드폰충전기 플러그를 빼는 것이 최적일 것이므로 플러그는 한 번만 빼면 된다. 

입력
첫 줄에는 멀티탭 구멍의 개수 N (1 ≤ N ≤ 100)과 전기 용품의 총 사용횟수 K (1 ≤ K ≤ 100)가 정수로 주어진다. 두 번째 줄에는 전기용품의 이름이 K 이하의 자연수로 사용 순서대로 주어진다. 각 줄의 모든 정수 사이는 공백문자로 구분되어 있다. 

출력
하나씩 플러그를 빼는 최소의 횟수를 출력하시오. 

예제 입력 1 
2 7
2 3 2 3 1 2 7
예제 출력 1 
2
*/

// 풀이
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
    // 플러그 들어간 물건들
		int plug[] = new int[N];
    // 플러그에 넣을 순서 process저장
		int process[] = new int[K];
    // process를 이동할 순서 cnt
		int cnt = 0;
    // 플러그를 빼는 수를 적을 ans
		int ans = 0;
    
    // 입력받기
		for( int i=0; i<K; i++ )
			process[i] = sc.nextInt();
		
    // 플러그에 빈공간이 없을때까지 새로운 process를 넣어준다.
    for( int i=0; i<N; i++ ) {
      // 근데 이미 꽂혀있으면 뺴고 꽂을 이유가 없다.
			boolean inalready = false;
			
      // 모든 플러그를 확인해서
			for( int j=0; j<N; j++) {
        // 만약에 꽂으려는 기기가 이미 꽂혀있으면
				if( plug[j] == process[cnt] ) {
          // 이미 존재한다 -> true
					inalready = true;
          // 그리고 plug에 값이 들어가지 않으므로 빈공간 하나를 빼준다.
					i--;
				}
			}
      // 꽂혀있지 않은 경우 꽂아준다.
			if( !inalready ) {
				plug[i] = process[cnt];
			}
      // 다음 기기를 확인한다.
			cnt++;
		}
		
    // 이제부터는 모든 플러그가 꽂혀있는 상태일 것이다.
    
		while(cnt<K) {
      // exist가 true이면 뒤에 해당 기기는 다시 plug에 꽂힌다. false면 다시는 안쓴다.
			boolean exist[] = new boolean[N];
      // 어떤 플러그가 먼저 꽂힐지 판단하는 later
			int later = -1;
      // 그 플러그 위치 in
      int in = 0;
      // done, check -> 경우의 수 확인용 bool값
			boolean done = false;
			boolean check = false;
			
      // 1. 기기가 이미 플러그에 꽂혀있는 경우
			for( int i=0; i<N; i++ ) {
				if( plug[i] == process[cnt] ) {
          // 이미 존재한다 -> 그럼 뒤를 할 필요 없으니 check -> true
					check = true;
					break;
				}
			}
			
      // 기기가 플러그에 꽂혀있지 않은 경우 진행한다.
			if( !check ) {
				for( int i=0; i<N; i++ ) {  
					for( int j=cnt; j<K; j++ ) {
            // 현재 꽂을 cnt부터 확인해서 가장 나중에 사용하는 기기를 지금 빼면 될 것이다.
						if( plug[i] == process[j] ) {
               // j의 최대값이 가장 뒤에 위치하는 기기
							if( later < j ) {
                // 가장 뒤의 것 저장, 해당 플러그의 위치 in 저장
								later = j;
								in = i;
							}
              // 어쨌든 해당 플러그의 기기는 나중에 사용할 것이다. 따라서 해당 위치 exist는 true
							exist[i] = true;
							break;
						}
					}
          // 위에서 모든 플러그를 확인해서 뒤에 사용하지 않으면 가장 우선해서 빼주면 될 것이다.
          // 2. 다시는 사용하지 않는 기기의 경우
					if( !exist[i] ) {
            // 사용하지 않는 위치를 cnt로 바꾸어 주고 나가면 된다.
						plug[i] = process[cnt];
            // 이미 해당 기기를 바꾸었기 때문에 어떤 기기가 가장 나중에 바뀌는지에 대해서는 고려할 필요가 없다. 이미 해당 과정 진행완료 done -> true
						done = true;
            // 플러그를 뺐으므로 ans를 하나 더해줌.
						ans++;
						break;
					}
				}
        // 3. 모든 기기를 한번씩 뒤에 사용하는 경우 -> 가장 뒤에 사용하는 기기 구하기
        // 아직 과정이 진행되지 않았음
				if( !done ) {
          // 가장 뒤의 플러그 위치 in을 현재 바꾸려는 기기로 바꾸어 준다.
					plug[in] = process[cnt];
          // 플러그 뺐으므로 ans + 1
					ans++;
				}
			}
      // 모두 진행하면 다음 기기 확인을 위해 cnt + 1
			cnt++;
		}
		
    // 정답 출력
		System.out.println(ans);
		
		
	}
	
}
