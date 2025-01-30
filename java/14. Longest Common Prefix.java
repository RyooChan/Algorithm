class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        int index = 0;
        boolean keepGoing = true;

        if(strs.length == 0) return "";

        while(keepGoing){
            if(strs[0].length() <= index) return sb.toString();
            char now = strs[0].charAt(index);
            for(int i=1; i<strs.length; i++) {
                if(strs[i].length() <= index) {
                    keepGoing = false;
                    break;
                }
                if(now != strs[i].charAt(index)) {
                    return sb.toString();
                }
            }
            if(!keepGoing) return sb.toString();
            index++;
            sb.append(now);
        }        
        
        return "";
    }
}
