class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0; // 글자 없으면 걍 0

        int ans = 1; // 하나라도 있으면 답은 1 이상
        for(int i=1; i<s.length(); i++) {
            HashSet<Character> hs = new HashSet<>(); // 확인을 위한 HashSet
            hs.add(s.charAt(i)); // 현재 값을 넣어준다.
            
            for(int j=i-1; j>=0; j--) { // 현재 기준으로 왼쪽으로 이동하면서 찾는다.
                char finder = s.charAt(j);  
                if(hs.contains(finder)) { // 왼쪽거가 이미 있다면 중복문자
                    break;
                } else { // 아니면 얘도 확인하기
                    hs.add(finder);
                }
            }
            ans = Math.max(ans, hs.size()); // 그래서 중복문자 제거한 값을 찾으면 된다.
        }

        return ans;
    }
}
