class Solution {
    public String intToRoman(int num) {
        Map<Integer, Character> hm = Map.of(
            1, 'I',
            5, 'V',
            10, 'X',
            50, 'L',
            100, 'C',
            500, 'D',
            1000, 'M'
        );

        StringBuilder sb = new StringBuilder();
        String numStr = num + "";

        for(int i=0; i<numStr.length(); i++) {
            int pow = (int)Math.pow(10, (numStr.length() - (i+1)));
            int now = numStr.charAt(i) - '0';

            if(now == 4) {
                sb.append(hm.get(pow));
                sb.append(hm.get(pow * (now+1)));
            } else if(now == 9) {
                sb.append(hm.get(pow));
                sb.append(hm.get(pow * 10));
            } else if(now == 5) {
                sb.append(hm.get(pow * now));
            } else if(now > 5) {
                sb.append(hm.get(pow * 5));
                for(int j=0; j<now - 5; j++) {
                    sb.append(hm.get(pow));
                }
            } else {
                for(int j=0; j<now; j++) {
                    sb.append(hm.get(pow));
                }
            }
        }
        
        return sb.toString();
    }
}
