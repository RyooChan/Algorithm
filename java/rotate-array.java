class Solution {
    public void rotate(int[] nums, int k) {
        int save[] = new int[nums.length];
        k %= nums.length;

        for(int i=0; i<nums.length; i++) {
            int index = i - k;
            if (index < 0) index += nums.length;
            save[i] = nums[index];
        }

        for(int i=0; i<nums.length; i++) nums[i] = save[i];
    }
}
