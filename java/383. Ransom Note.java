class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i=0; i<magazine.length(); i++) {
            hm.put(magazine.charAt(i), (hm.getOrDefault(magazine.charAt(i), 0) + 1));
        }

        for(int i=0; i<ransomNote.length(); i++) {
            int cnt = hm.getOrDefault(ransomNote.charAt(i), 0);
            if(cnt <= 0) return false;
            hm.put(ransomNote.charAt(i), cnt-1);
        }

        return true;
    }
}
