class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> hm = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );

        int ans = 0;
        int before = 0;

        for(int i=s.length() - 1; i>=0; i--) {
            int now = hm.get(s.charAt(i));
            if(now < before) {
                ans -= now;
            } else {
                ans += now;
            }
            before = now;
        }
        return ans;
    }
}
