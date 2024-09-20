// https://www.hackerrank.com/challenges/sock-merchant/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

    public static int sockMerchant(int n, List<Integer> ar) {
    // Write your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        
        for(int i=0; i<n; i++) {
            hm.put(ar.get(i), hm.getOrDefault(ar.get(i), 0) + 1);    
        }
        
        for(Entry<Integer, Integer> entrySet : hm.entrySet()) {
            ans += entrySet.getValue() / 2;
        }

        return ans;
    }
