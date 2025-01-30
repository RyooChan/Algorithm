class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();

        // 한 문장을 만들 수 있는 큐
        Queue<String> queue = new LinkedList<>();
        int lineLength = 0; // space 제외한 문장의 길이

        for(String word : words) {
            // 현재 들어갈 단어 길이 + 이전 전체 단어 길이 총합 + space가 반드시 들어가야 하는 길이의 합 > 최대길이 라면 지금까지의 단어들로 문장을 구성해준다.
            if(word.length() + lineLength + queue.size() > maxWidth) {
                StringBuilder sb = new StringBuilder();
                int space = maxWidth - lineLength; // 필요한 space 갯수를 구한다.
                int minSpace = space / Math.max((queue.size()-1), 1); // 각 문장 옆에 들어갈 space의 최소 개수를 구한다(마지막 단어 뒤에는 안붙이는 space)
                StringBuilder spaceBuilder = new StringBuilder();
                for(int i=0; i<minSpace; i++) spaceBuilder.append(" "); // 그만큼 space를 미리 만들어 준다.
                int addSpace = space - (minSpace * Math.max((queue.size()-1), 1)); // 위의 최소 개수 외에도 최대길이를 만들어주기 위해 필요한 space 개수를 구한다.

                // 마지막 단어를 제외하고 문장을 만들어준다.
                while(queue.size() != 1) {
                    sb.append(queue.remove()).append(spaceBuilder);
                    if(addSpace-->0) { // 추가 필요한 space를 하나씩 더해준다.
                        sb.append(" ");
                    }
                    minSpace = 0; // 단어의 개수가 2개 이상이면 맨 뒤 이후 space를 더하지 않는다.
                }
                sb.append(queue.remove()); // 마지막 단어 추가
                while(minSpace-->0) sb.append(" "); // 근데 단어가 하나뿐이면 뒤에는 싹다 space로 채워준다.

                ans.add(sb.toString());
                lineLength = 0; // 전체 길이 초기화
            }
            // 현재 대상 단어를 더해준다.
            lineLength += word.length();
            queue.add(word);
        }

        // 마지막 문장 생성을 위함
        if(!queue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            // 마지막 문장은 단어 사이에 space는 하나뿐이다.
            while(queue.size() != 1) {
                sb.append(queue.remove()).append(" ");
            }
            // 마지막 문장 이후에 space 몰빵
            sb.append(queue.remove());
            int space = maxWidth - sb.length();
            for(int i=0; i<space; i++) sb.append(" ");
            ans.add(sb.toString());
        }

        return ans;
    }
}
