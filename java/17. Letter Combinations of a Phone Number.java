class Solution {
    private static char[][] nums = new char[10][4];
    private List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        // 걍 문자열 넣기
        char now = 'a';
        for(int i=2; i<=9; i++) {
            for(int j=0; j<3; j++) {
                nums[i][j] = now++;
                System.out.print(nums[i][j]);
            }
            if(i==7) nums[7][3] = now++;
            if(i==9) nums[9][3] = now++;
        }
        
        // 백트레킹 시작
        dfs(0, digits, "");
        return ans;
    }

    private void dfs(int index, String digits, String str) {
        // 목적지 도달시 적용
        if(index == digits.length()) {
            if(str != "") ans.add(str);
            return;
        }
        // 조건에 맞춰 실행
        for(int i=0; i<4; i++) {
            if(nums[digits.charAt(index) - '0'][i] != 0) {
                dfs(index+1, digits, str + nums[digits.charAt(index) - '0'][i]);
            }
        }
    }
}
