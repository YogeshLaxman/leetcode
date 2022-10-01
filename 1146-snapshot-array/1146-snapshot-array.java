class SnapshotArray {
    
    Map<Integer, TreeMap<Integer, Integer>> indexToSnapIdtoValueMap;
    int currentSnapId = 0;
    
    // O(length)
    public SnapshotArray(int length) {
        indexToSnapIdtoValueMap = new HashMap<>();
        for (int i=0; i<length; i++) {
            TreeMap<Integer, Integer> snapIdToValueMap = new TreeMap<>();
            snapIdToValueMap.put(0, 0);
            indexToSnapIdtoValueMap.put(i, snapIdToValueMap);
        }
    }
    
    // O(logn)
    public void set(int index, int val) {
        indexToSnapIdtoValueMap.get(index).put(currentSnapId, val);
    }
    
    //O(1)
    public int snap() {
        currentSnapId++;
        return currentSnapId-1;
    }
    
    // O(logn)
    public int get(int index, int snap_id) {
        // System.out.println(indexToSnapIdtoValueMap);
        // System.out.println(index + ":" + snap_id);
        return indexToSnapIdtoValueMap.get(index).floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */