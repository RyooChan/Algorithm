class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        for(int i=0; i<s.length(); i++) {
            if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) sb.append(s.charAt(i));
        }

        s = sb.toString();
        System.out.println(sb.toString());
        for(int i=0; i<s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
}
