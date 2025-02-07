class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0; // 슬라이딩 윈도우 시작점
        int sum = 0; // 총합
        int cnt = 0; // 구한 배열 갯수
        int ans = nums.length+1; // 정답인데, 모든 배열을 다 더해도 현재 크기가 나오지 않기 때문에 이로 세팅

        for(int i=0; i<nums.length; i++) {
            // 일단 현재 위치까지의 값을 다 더해준다.
            cnt++;
            sum += nums[i];

            // 그리고 그게 target보다 크거나 같으면 일단 output에 해당한다.
            if (sum >= target) {
                while(sum >= target) { // 그래서 앞에 데이터를 줄일 수 있는 데까지 줄여본다.
                    ans = Math.min(ans, cnt); // 정답 갱신
                    cnt--; // 앞에부터 하나씩 빼주기
                    sum -= nums[start];
                    start++;
                }
            } 
        }

        if(nums.length+1 == ans) return 0; // 답 없으면 이크기 그대로
        return ans;
    }
}
