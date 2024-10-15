    public static List<Integer> rotLeft(List<Integer> a, int d) {
        int maxLength = a.size();
        
        d %= maxLength;
        List<Integer> ans = new ArrayList<>(Collections.nCopies(maxLength, 0));
        
        for(int i=0; i<maxLength; i++) {
            int index = i - d;
            if(index<0) index += maxLength;
            ans.set(index, a.get(i));
        }
        
        return ans;
    }
