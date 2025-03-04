class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ansList = new ArrayList<>();
        int i = 0;

        // 새로 추가되는 interval 보다 앞에 있는 것들은 그냥 넣어준다.
        for(i=i; i<intervals.length; i++) {
            int[] now = intervals[i];
            if(now[1] >= newInterval[0]) break;
            ansList.add(now);
        }

        // 새로 추가되는 interval 을 중간에 넣는다.
        for(i=i; i<intervals.length; i++) {
            int[] now = intervals[i];
            if(newInterval[1] < now[0]) break; // 더이상 겹치지 않는 부분은 새로 추가되는게 지금 앞보다 이전에 있을때
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        }
        ansList.add(newInterval);

        // 나머지 넣으면 끝
        for(i=i; i<intervals.length; i++) {
            ansList.add(intervals[i]);
        }

        return ansList.toArray(new int[ansList.size()][]);
    } 
}
