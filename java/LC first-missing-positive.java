class Solution {
    public int firstMissingPositive(int[] nums) {
        int maxVal = nums.length; // "양의 정수의 최대값" 은 배열 크기 + 1
        
        for(int i=0; i<maxVal; i++) {
            int now = nums[i];
            // 음수면 무시, 그게 아니면 배열 순서대로 저장
            // 예를 들어 숫자 2의 위치는 배열 1에(2번째 위치에) 있어야 한다.
              // 근데 1,1 이러면 바꿔도 의믜 없으니 그건 제외
            if(now > 0 && now<maxVal && now != i+1 && nums[i] != nums[now-1]) {
                nums[i] = nums[now-1];
                nums[now-1] = now;
                i--;
            }
        }

        // 배열 돌면서 내보낼 숫자 확정
        int ans = 1;
        for(int i=0; i<maxVal; i++) {
            if(nums[i] == ans) ans++;
        }

        return ans;
    }
}
