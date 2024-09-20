// https://www.hackerrank.com/challenges/counting-valleys/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup



    public static int countingValleys(int steps, String path) {
    // Write your code here
        int heights = 0;
        int ans = 0;
        
        for (int i=0; i<steps; i++) {
            char step = path.charAt(i);
            if (step == 'U') {
                heights++;
                
                if (heights == 0) {
                    ans++;
                }
                
            } else {
                heights--;
            }
            
        }
        
        return ans;
    }

}
