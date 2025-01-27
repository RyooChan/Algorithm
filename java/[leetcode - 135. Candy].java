
class Solution {
    private static int[] candies;

    public int candy(int[] ratings) {
        LinkedList<Integer> startQueue = new LinkedList<>();
        candies = new int[ratings.length];

        // 한명이면 걍 하나만 주면 된다.
        if (ratings.length == 1) return 1;

        // 모든 사람에 대해
        for(int i=0; i<ratings.length; i++) {
            if(i == 0) { // 맨 왼쪽이면 오른쪽보다 크기가 작거나 같으면 사탕 하나만 주면 된다.
                if(ratings[i] <= ratings[i+1]) startQueue.add(i); // 그 옆 친구는 얘보다는 많이 있을거임
                candies[i] = 1;
            } else if(i == ratings.length - 1) { // 반대쪽 끝
                if(ratings[i] <= ratings[i-1]) startQueue.add(i);
                candies[i] = 1;
            } else { // 가운데는 둘 다 이 친구보다 크거나 같으면 얘는 무조건 사탕 1개 가짐
                if(ratings[i] <= ratings[i-1] && ratings[i] <= ratings[i+1]) startQueue.add(i);
                candies[i] = 1;
            }
        }

        // 그 친구 기준 양옆으로 확인해준다.
        while(!startQueue.isEmpty()) {
            int index = startQueue.poll();
            dfs(index + 1, index, ratings);
            dfs(index - 1, index, ratings);
        }

        int ans = 0;
        for (int candy : candies) {
            ans += candy;
        }

        return ans;
    }

    private static void dfs(int index, int beforeIndex, int[] ratings) {
        if (index < 0 || index >= candies.length) return;

        int now = ratings[index];
        int before = ratings[beforeIndex];

        // 이친구가 점수가 더 높다면
        if (now > before) {
            // 지금 구해둔 사탕 개수 혹은 이전친구보다 하나 더 많이 갖는것중 하나 선택
            // 다른 dfs 과정에서 (다른친구부터 비교해서 얻는 사탕이) 얻은게 더 크면 그게 얘가 가질 사탕
            candies[index] = Math.max(candies[index], candies[beforeIndex] + 1);
        } else return; // 그렇지 않다면 더 볼필요가 없다. 이전 친구의 사탕을 더 알필요가 없어짐.

        // 오른쪽 / 왼쪽 중 어디서왔는지 확인해서 그 방향으로 계속 진행
        dfs(index + (index - beforeIndex), index, ratings);
    }
}
