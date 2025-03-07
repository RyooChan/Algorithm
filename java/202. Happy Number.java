class Solution {
    public boolean isHappy(int n) {
        String str = n + "";
        HashSet<String> hs = new HashSet<>();
        while(!str.equals("1")) {
            int sum = 0;
            for(int i=0; i<str.length(); i++) {
                int num = str.charAt(i) - '0';
                sum += Math.pow(num, 2);
            }  
            str = sum + "";
            if(hs.contains(str)) return false;
            hs.add(str);
        }
        
        return true;
    }
}
