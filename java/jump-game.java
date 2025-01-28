class Solution {
    private static boolean check[];
    private static boolean ans;

    public boolean canJump(int[] nums) {
        check = new boolean[nums.length];
        ans = false;
        jump(0, nums);
        return ans;
    }

    private static void jump(int index, int[] nums) {
        check[index] = true;
        int nextIndex = index + nums[index];

        if(nextIndex >= nums.length - 1) {
            ans = true;
            return;
        }

        for(int i=index+1; i<=nextIndex; i++) {
            if(ans) return;
            if(!check[i]) jump(i, nums);
        }
    }
}
