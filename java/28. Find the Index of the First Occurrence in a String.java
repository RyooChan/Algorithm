class Solution {
    public int strStr(String haystack, String needle) {
        for(int i=0; i<haystack.length() - needle.length() + 1; i++) {
            String str = haystack.substring(i, i+needle.length());
            if(str.equals(needle)) return i;
        }
        return -1;
    }
}
