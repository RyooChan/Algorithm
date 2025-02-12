class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLeng = words[0].length();
        int wholeLeng = words.length * wordLeng;
        
        // 최초 없는 경우 체크
        if (s == null || s.length() == 0 || words == null || words.length == 0 || s.length() < words.length || s.length() < wholeLeng) {
            return new ArrayList<>();
        }

        // 정답 확인
        List<Integer> ans = new ArrayList<>();

        // words 들의 등장 빈도를 체크하는 HashMap 생성
        HashMap<String, Integer> wordsMap = new HashMap<>();
        for(String word : words) wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);

        // 문자를 확인하는 지점의 시작점 -> 처음부터, 한칸 띄고, ... 이거를 전체 배열의 크기만큼 해주면 된다.
        // 이렇게 한 이유는 단어를 하나씩 만들고 빼면서 구하기 위함이다.
        for(int i=0; i<wordLeng; i++) { 
            int delete = i; // 맨 앞 단어 삭제를 위함
            int createCnt = (s.length() - i) / wordLeng; // 현재 문자열에서 만들 수 있는 총 개수
            HashMap<String, Integer> compareMap = new HashMap<>(); // s 에서 만들어낸 등장 빈도를 체크하는 해시맵
            
            // 처음에 words 길이만큼 HashMap 채워준다
            // 뒤의 and 조건 추가 이유는 이렇게 만들어진 값이 s를 넘어가는 경우 진행할 수 없기 때문이다.
            for(int j=0; j<words.length && (j+1) * wordLeng + i <= s.length(); j++) {
                int from = i + j * wordLeng;
                int to = (j+1) * wordLeng + i;
                String now = s.substring(from, to);

                compareMap.put(now, compareMap.getOrDefault(now, 0) + 1);
            }

            if(wordsMap.equals(compareMap)) ans.add(i); // 최초 지점에 대한 비교

            // 그 다음부터 슬라이딩 윈도우를 통해 단어를 하나씩 빼고 더하면서 비교해준다.
            for(int j=words.length; j<createCnt; j++) {
                String deleteKey = s.substring(delete, delete+wordLeng);
                int newVal = compareMap.get(deleteKey) - 1;

                if(newVal > 0) compareMap.put(deleteKey, newVal);
                else compareMap.remove(deleteKey);

                delete+=wordLeng;

                int from = i + j * wordLeng;
                int to = (j+1) * wordLeng + i;
                String now = s.substring(from, to);

                compareMap.put(now, compareMap.getOrDefault(now, 0) + 1);

                if(wordsMap.equals(compareMap)) ans.add(i + ((j-words.length+1)*wordLeng));
            }
        }

        return ans;
    }

}
