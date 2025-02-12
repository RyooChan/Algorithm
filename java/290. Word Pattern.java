class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> hm1 = new HashMap<>();
        HashMap<String, Character> hm2 = new HashMap<>();
        String[] spl = s.split(" ");

        if(spl.length != pattern.length()) return false;

        for(int i=0; i<pattern.length(); i++) {
            char chr = pattern.charAt(i);
            String str = spl[i];
            if(!hm1.containsKey(chr) && !hm2.containsKey(str)) {
                hm1.put(chr, str);
                hm2.put(str, chr);
            } else if(!hm1.getOrDefault(chr, " ").equals(str) || !hm2.getOrDefault(str, ' ').equals(chr)) return false;
        }

        return true;
    }
}
