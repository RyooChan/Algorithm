class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int now = nums[i];
            int need = target - now;
            if(hm.containsKey(need)) {
                return new int[]{hm.get(need), i};
            } else {
                hm.put(now, i);
            }
        }

        return null;
    }
}
