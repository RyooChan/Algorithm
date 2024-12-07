/******************************************************************************

 Online Java Compiler.
 Code, Compile, Run and Debug java program online.
 Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/
import java.util.*;

public class Main
{
    private static Map<Integer, List<Integer>> parentMap = new HashMap<>();
    private static Map<Integer, Integer> findParent = new HashMap<>();
    private static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());
        for (int i=0; i<count; i++) {
            int parent = sc.nextInt();
            findParent.put(i, parent);  // 지금 들어가는 노드의 부모를 찾는다.
            if(parent == -1) continue;
            List<Integer> children = parentMap.getOrDefault(parent, new ArrayList<Integer>()); // 어떤 노드의 자식들을 보관한다.
            children.add(i);
            parentMap.put(parent, children); // key: 부모, value: 자식
        }

        int remove = sc.nextInt();

        for(int i=0; i<count; i++) {
            if(!parentMap.containsKey(i)) ans++; // 자식이 없는 노드는 리프노드이다.
        }
        
        // 검색할 때에 이 부모가 하나의 자식밖에 없다면 이게 지워지면 그 부모가 리프노드가 된다.
        if(parentMap.getOrDefault(findParent.get(remove), new ArrayList<Integer>()).size() == 1) ans++;
        if(remove >=0 && remove < count) DFS(remove);

        System.out.println(ans);
    }

    // 삭제 대상 확인 DFS
    private static void DFS(int parent) {
        // 지금 이게 자식이 없는 노드이면 리프노드이므로 삭제처리
        if (!parentMap.containsKey(parent)) {
            ans--;
            return;
        }

        // 부모노드라면 자식들을 제거
        List<Integer> children = parentMap.get(parent);
        for(int child : children) DFS(child);
    }
}
