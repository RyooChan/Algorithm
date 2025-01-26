class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        int max = nums.length / 2;

        for(int i=0; i<nums.length; i++) {
            int index = nums[i];
            int count = counter.getOrDefault(index, 0) + 1;
            if (count > max) return index;
            counter.put(index, count);
        }

        return -1;
    }
}
