class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // 투포인터 실행을 위한 list 정렬
        Arrays.sort(nums);

        // 3개 찾아야 하니까 2개 남겨놓음
        for(int i=0; i<nums.length - 2; i++) {
            if(i != 0 && nums[i] == nums[i-1]) continue; // 숫자 중복 제거를 위함, i가 start

            int mid = i + 1; // 왼
            int end = nums.length - 1; // 오

            while(mid < end) {
                // 숫자 중복 제거
                if(mid != i+1 && nums[mid] == nums[mid-1]) {
                    mid++;
                    continue;
                } else if (end != nums.length - 1 && nums[end] == nums[end + 1]) {
                    end--;
                    continue;
                }

                // 만든 숫자가
                int num = nums[i] + nums[mid] + nums[end];
                if(num == 0) { // 정답이면 입력하고
                    ans.add(List.of(nums[i], nums[mid], nums[end]));
                    mid++; // 얘네 둘다 다시 쓰일 일 없음
                    end--;
                } else if(num < 0) { // 나머지 투포인터 진행
                    mid++;
                } else {
                    end--;
                }
            }
        }

        return ans;
    }
}
