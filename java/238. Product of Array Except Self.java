class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        long allMul = 1; // 전체를 곱할 때 사용하는 allMul
        boolean containsZero = false; // 하나라도 0 을 포함하는지 여부
        boolean containsDoubleZero = false; // 0이 두개 이상인지 여부

        for(int num : nums) {
            if(num == 0) {
                if(containsZero) containsDoubleZero = true;
                containsZero = true;
            }
            else allMul *= num; // 전체 곱을 구한다.
        }

        // 0이 두개 이상이라면 모든 곱셈이 다 0이 나올 수밖에 없다.
        if(containsDoubleZero) return answer;

        for(int i=0; i<answer.length; i++) {
            if(nums[i] != 0) { // 지금 값이 0이 아니라면
                if (containsZero) answer[i] = 0; // 다른 곳에 0이 있다면 무조건 0
                else answer[i] = (int)(allMul / nums[i]); // 다른 곳에 0이 없다면 지금꺼만 나눠줌
            } else {
                answer[i] = (int) allMul; // 이게 0이고, 0은 1개만 있으므로 모든 값의 곱이 정답이 된다.
            }
        }

        return answer;
    }
}
