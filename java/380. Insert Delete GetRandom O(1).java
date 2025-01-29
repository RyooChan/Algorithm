class RandomizedSet {
    private List<Integer> list;
    private Set<Integer> hs;
    private Random random;
    private int size = 0;

    public RandomizedSet() {
        list = new ArrayList<>();
        hs = new HashSet<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(hs.contains(val)) {
            return false;
        }
        list.add(val);
        hs.add(val);
        size++;
        return true;
    }
    
    public boolean remove(int val) {
        if(hs.contains(val)) {
            list.remove(Integer.valueOf(val));
            hs.remove(val);
            size--;
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(size);
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
