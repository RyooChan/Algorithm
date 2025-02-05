class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while(true) {
            int now = numbers[start] + numbers[end];
            if(now > target) end--;
            else if(now < target) start++;
            else return new int[]{start+1, end+1};
        }
    }
}
