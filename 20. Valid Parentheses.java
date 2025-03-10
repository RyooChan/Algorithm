class Solution {
    public boolean isValid(String s) {
        Stack<Character> valid = new Stack<>();
        Map<Character, Character> hm = Map.of(
            '(', ')', 
            '{', '}', 
            '[', ']'
        );

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' ) valid.push(s.charAt(i));
            else {
                if(valid.isEmpty() || hm.get(valid.pop()) != s.charAt(i)) return false;
            }
        }

        if(valid.size() == 0) return true;
        else return false;
    }
}
