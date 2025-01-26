class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        boolean canDup = false;
        for(int i=1; i<nums.length; i++) {
            if(nums[index] != nums[i]) {
                nums[++index] = nums[i];
                canDup = true;
            } else if(canDup || index == 0) {
                canDup = false;
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }
}
