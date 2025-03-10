class Solution {
    public int longestConsecutive(int[] nums) {
        // 없으면 걍 0
        if(nums.length == 0) return 0;

        int ans = 1;
        int cnt = 1;

        Arrays.sort(nums); // 최초 정렬 진행 -> O(n)
        for(int i=1; i<nums.length; i++) { // n의 갯수에 대해 진행 -> O(n)
            if(nums[i]-1 == nums[i-1]) { // 숫자가 증가한다면 이어진 숫자이다.
                cnt++;
            } else if(nums[i] != nums[i-1]) { // 참고로 같은 숫자가 연이어 있어도 문제가 없다. 그게 아닌 경우만 끊어짐
                cnt = 1;
            }
            ans = Math.max(ans, cnt); // 정렬 진행
        }

        return ans;
    }
}
