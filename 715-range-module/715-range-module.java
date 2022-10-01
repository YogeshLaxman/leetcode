class RangeModule {
    
    TreeMap<Integer, Integer> rangeMap;
    public RangeModule() {
        rangeMap = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        Integer leftIntervalKey = rangeMap.floorKey(left);
        Integer rightIntervalKey = rangeMap.floorKey(right);
        
        if (leftIntervalKey != null) {
            if (rangeMap.get(leftIntervalKey) >= left) {
                left = leftIntervalKey;
            }
        }
        
        if (rightIntervalKey != null) {
            right = Math.max(right, rangeMap.get(rightIntervalKey));
        }
        
        Map<Integer, Integer> subMap = rangeMap.subMap(left, true, right, true);
        Set<Integer> set = new HashSet(subMap.keySet());
        rangeMap.keySet().removeAll(set);
        
        rangeMap.put(left, right);
        
        // System.out.println("After addition: (" + left +", " + right + ")");
        // System.out.println(rangeMap);
    }
    
    public boolean queryRange(int left, int right) {
        Integer leftIntervalKey = rangeMap.floorKey(left);
        if (leftIntervalKey != null) {
            if (rangeMap.get(leftIntervalKey) >= left && rangeMap.get(leftIntervalKey) >= right)  {
                return true;
            }
        }
        
        return false;
    }
    
    public void removeRange(int left, int right) {
        Integer leftIntervalKey = rangeMap.floorKey(left);
        Integer rightIntervalKey = rangeMap.floorKey(right);
        
        if (rightIntervalKey != null) {
            if (right < rangeMap.get(rightIntervalKey)) {
                rangeMap.put(right, rangeMap.get(rightIntervalKey));
            }
        }
        
        if (leftIntervalKey != null) {
            if (leftIntervalKey < left && rangeMap.get(leftIntervalKey) >= left) {
                rangeMap.put(leftIntervalKey, left);
            }
        }
        
        
        
        Map<Integer, Integer> subMap = rangeMap.subMap(left, true, right, false);
        Set<Integer> set = new HashSet(subMap.keySet());
        rangeMap.keySet().removeAll(set);
        
        // System.out.println("After removal: (" + left +", " + right + ")");
        //System.out.println(rangeMap);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */