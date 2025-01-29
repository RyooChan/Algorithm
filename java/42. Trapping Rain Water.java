class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        // 각각 투포인터의 시작점
        int left = 0;
        int right = height.length - 1;
        // 오른쪽 / 왼쪽 최대 높이 블록 높이
        int leftMax = 0;
        int rightMax = 0;
        // 물방울 수
        int total = 0;

        while(left <= right) { // 투포인터 시작
            int leftHeight = height[left];
            int rightHeight = height[right];
            if(leftHeight < rightHeight) { // 왼쪽이 더 작은 경우(참고로 이 과정에서 왼쪽 최대가 현재 오른쪽보다 작다는것은 이미 검증된 상태이다.) 
                if(leftMax <= leftHeight) { // 지금이 최대 블록이면 갱신
                    leftMax = leftHeight;
                } else { // 그렇지 않다면 여기는 왼쪽의 최대만큼 물이 쌓인다
                    total += leftMax - leftHeight; 
                }
                left++; // 다음 포인터 진행
            } else { // 요건 오른쪽
                if(rightMax <= rightHeight) {
                    rightMax = rightHeight;
                } else {
                    total += rightMax - rightHeight;
                }
                right--;
            }
        }

        return total;
    }
}
