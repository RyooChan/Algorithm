class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] spent = new int[gas.length];
        LinkedList<Integer> startPoint = new LinkedList<>();
        int all = 0;

        for(int i=0; i<gas.length; i++) {
            spent[i] = gas[i] - cost[i];    
            all += spent[i];
            if(spent[i] > 0) startPoint.add(i);
        }

        // 받은 양보다 쓴게 많다면 어차피 못간다.
        if(all < 0) return -1;
        if(gas.length == 1) return 0; // 시작점이 도착점 

        while(!startPoint.isEmpty()) {
            int start = startPoint.remove(); // 다음 장소로 이동할 수 있는 모든 곳에서
            int distance = 0; // 출발
            boolean canReach = true;
            for(int i=start; i<start + spent.length; i++) { // 현 위치에서 다시 현위치로 돌아오면서
                int index = i % spent.length;
                distance += spent[index]; // 그 거리가 도달이 가능한지 확인
                if(distance < 0) { // 거기 도달이 안되면 이건 어차피 안됨
                    canReach = false;
                    break;
                }
            }
            if(canReach) return start; // 이게 도달점
        }
        return -1;
    }
}
