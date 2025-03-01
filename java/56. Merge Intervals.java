class Solution {
    public int[][] merge(int[][] intervals) {
        // 정렬에 대한 얘기가 처음에 없음. 근데 시작점만 정렬해주면 될듯?
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // 최초 배열 만들기용 숫자 적용
        int start = intervals[0][0];
        int end = intervals[0][1];

        List<int[]> arr = new ArrayList<>();

        for(int i=1; i<intervals.length; i++) {
            if(end >= intervals[i][0]) { // 겹칠 수 있다면
                end = Math.max(end, intervals[i][1]); // 겹치고, 뒤에 크기는 더 큰걸로 해야함(앞이 더 클수도 있으니)
            } else {
                int[] ii = {start, end}; // 안겹치면 앞에꺼 더하고
                arr.add(ii);

                start = intervals[i][0]; // 다시 배열 생성용 숫자 적용
                end = intervals[i][1];
            }
        }

        // 끝까지 해서 나왔으면 마지막꺼 적용하기
        int[] ii = {start, end};
        arr.add(ii);

        return arr.toArray(new int[arr.size()][]);    
    }
}
