class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int half = (nums1.length + nums2.length) % 2;
        int mid = (nums1.length + nums2.length) / 2 + half; // 가운데는 중간점을 잡아야 한다. 기본적으로 내림이라 홀수개면 하나 더해줌

        // 방어로직
        if(nums1.length + nums2.length == 1) {
            if(nums1.length == 0) return nums2[0];
            return nums1[0];
        }
        
        int left = 0; // nums1 을 처음부터 보는 left
        int right = 0; // nums2 를 처음부터 보는 right
        int sum = 0; // median 구하기 위한 sum

        // 중간이 될 때까지 구하기
        while(mid-->0) {
            int now;
            if(!(nums2.length > right) || (nums1.length > left && nums1[left] <= nums2[right])) { // nums2의 끝까지 탐색했다면 무조건 nums1 탐색 필요, 혹은 반대, 그게 아니라면 둘 중 작은 것을 찾는다.
                now = nums1[left];
                left++;
            } else {
                now = nums2[right];
                right++;
            }

            if(mid == 0) { // 가운데면 sum 에 추가
                sum += now;
                if(half == 0) { // 근데 짝수개면 두개 더해서 평균 구해야 하므로 한번 더 찾아준다.
                    half = -1; // 이거는 밖에서 짝수개임을 알수있게 마이너스로
                    mid++;
                }
            }
        }

        if(half == -1) return (float)(sum/2.0); // 홀수면 나눠
        return sum;
    }
}
