class Solution {
    public int hIndex(int[] citations) {
        // 인용이 많이 된 것부터 저장한다.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int max = 0; // 여기서부터 찾으면 된다.

        for(int i=0; i<citations.length; i++) {
            max = Math.max(max, citations[i]);
            pq.add(citations[i]);
        }

        int count = 0; // 현재 h-index 보다 많거나 같은 인용을 한 논문의 갯수 count
        for(int i=max; i>=0; i--) {
            while(!pq.isEmpty() && pq.peek() >= i) { // 현재 h-index 보다 인용을 많이 했거나 같은 인용이면 이건 count의 대상이 된다.
                count++;
                pq.remove();
            }
            
            if(count >= i) return i; // 그게 h-index 조건을 만족하면 돌려주면 된다.
        }

        return 0; // 하나라도 인용을 받은 논문이 있다면 여기로 도달할 수 없다. 여기는 인용을 아예 못받은 논문만 있을 때 도달한다.
    }
}
