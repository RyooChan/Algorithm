class Solution {
    public String convert(String s, int numRows) {
        // 위의 경우에는 지그재그가 애초에 안나온다.
        if(numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int index = 0; // 얘는 어디 위치인지를 알기위한 index
        boolean isForward = true; // 지그재그로 가면서 위치를 정하는데 위아래를 정하기 위한 bool
        Queue<Character>[] queues = new Queue[numRows]; // 지그재그 문자열의 현 문자가 어디인지를 확인하기 위한 큐 배열

        for (int i = 0; i < queues.length; i++) {
            queues[i] = new LinkedList<>();
        }

        for(int i=0; i<s.length(); i++) {
            queues[index].add(s.charAt(i)); // 현 위치는 어디 위치인지를 저장한다.

            // 지그재그 방향에 따라 들어갈 queue 위치 확인
            if(isForward) index++;
            else index--;

            // 지그재그 위아래 이동
            if(index == 0) isForward = true;
            else if(index == numRows-1) isForward = false;
        }

        // 문자열 생성해주기
        for(int i=0; i<numRows; i++) {
            while(!queues[i].isEmpty()) {
                sb.append(queues[i].remove());
            }
        }

        return sb.toString();
    }
}
