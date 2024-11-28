import java.util.*;

public class Main
{
  private static List<Egg> eggList = new ArrayList<>();
  private static int size;
  private static int ans = 0;
  
	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    
    for(int i=0; i<N; i++) {
      int durablilty = sc.nextInt();
      int weight = sc.nextInt();
      eggList.add(new Egg(durablilty, weight));
    }

    // 마지막 계란의 위치를 기억한다.
    size = N;
    
    BF(0, 0);
    System.out.println(ans);
	}

	private static void BF(int index, int count) {
    // 모든 위치에 도달할 때마다 결과값을 저장해도 상관없다. 어차피 마지막까지 깨는 모든 경우를 다 포함
    ans = Math.max(ans, count);

    // 맨 마지막 계란을 테스트한 후에는 끝
	  if(index == size) {
	    return;
	  }

    // 지금 드는 계란
	  Egg nowEgg = eggList.get(index);
	  int durablilty = nowEgg.durablilty;
	  int weight = nowEgg.weight;

    // 깨져있으면 다음꺼 확인
	  if(durablilty <= 0) {
	    BF(index+1, count);
	    return;
	  }
	  
	  for(int i=0; i<size; i++) {
	    if (index == i) continue; // 지금계란은 테스트 불가
	    
	    int counter = count; // 몇개나 깼는지 확인하기 위함

      // 깨볼 계란
	    Egg targetEgg = eggList.get(i);
	    int targetDur = targetEgg.durablilty;
	    int targetWeight = targetEgg.weight;
	    
	    if(targetDur <= 0) continue; // 이미 깨져있으면 테스트하지 않는다.

      // 두드려보고
	    durablilty -= targetWeight;
	    targetDur -= weight;

      // 꺠졌으면 체크
	    if(targetDur <= 0) counter++;
	    if(durablilty <= 0) counter++;

      // 그 계란의 정보를 저장하고
	    eggList.set(index, new Egg(durablilty, weight));
	    eggList.set(i, new Egg(targetDur, targetWeight));

      // 이 계란을 테스트한 후에는 기존 계란은 냅두고 다시 다른 계란으로 테스트한다 (DFS)
	    BF(index+1, counter);

      // 위의 DFS가 끝났으면 다른 테스트를 위해 아무일 없던것처럼 세팅
	    durablilty += targetWeight;
	    targetDur += weight;
	    eggList.set(index, new Egg(durablilty, weight));
	    eggList.set(i, new Egg(targetDur, targetWeight));
	  }
	}
}
	
class Egg {
  int durablilty;
  int weight;
  
  public Egg(int durablilty, int weight) {
    this.durablilty = durablilty;
    this.weight = weight;
  }
}
