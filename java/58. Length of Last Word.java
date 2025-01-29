class Solution {
    public int lengthOfLastWord(String s) {
        int leng = 0;
        boolean isNotSpace = false;
        for(int i=s.length()-1; i>=0; i--) {
            char now = s.charAt(i);
            if(now != ' ') {
                isNotSpace = true;
                leng++;
            } else {
                if(isNotSpace) return leng;
            }
        }
        return leng;
    }
}
