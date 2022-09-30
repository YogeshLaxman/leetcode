class RangeModule {
    List<int[]> intervals;
    
    public RangeModule() {
        intervals = new ArrayList<>();
    }
    
    public void addRange(int left, int right) {
        right--;
        
        List<int[]> newIntervals = new ArrayList<>();
        boolean added = false;
        
        for (int[] interval: intervals) {
            boolean leftInside = interval[0] <= left && left <= interval[1];
            boolean rightInside = interval[0] <= right && right <= interval[1];
            boolean fullInside = left <= interval[0] &&  interval[1] <= right;
            
            if (leftInside || rightInside || fullInside || right+1 == interval[0] || interval[1] + 1== left) {
                left = Math.min(interval[0], left);
                right = Math.max(interval[1], right);
            } else {
                if (right < interval[0] && !added) {
                    newIntervals.add(new int[] {left, right});
                    added = true;
                }
                newIntervals.add(interval);
            }
        }
        
        if (!added) {
            newIntervals.add(new int[] {left, right});
        }
        
        intervals = newIntervals;
        
        // System.out.println("After addition: (" + left +", " + right + ")");
        // print();
    }
    
    public boolean queryRange(int left, int right) {
        right--;
        
        for (int[] interval: intervals) {
            boolean leftInside = interval[0] <= left && left <= interval[1];
            boolean rightInside = interval[0] <= right && right <= interval[1];
            
            if (leftInside && rightInside) {
                return true;
            }
        }
        
        return false;
    }
    
    public void removeRange(int left, int right) {
        right--;
        
        List<int[]> newIntervals = new ArrayList<>();
        
        for (int[] interval: intervals) {
            boolean leftInside = interval[0] <= left && left <= interval[1];
            boolean rightInside = interval[0] <= right && right <= interval[1];
            boolean fullInside = left <= interval[0] &&  interval[1] <= right;
            
            if (leftInside || rightInside || fullInside) {
                if (interval[0] <= left-1) {
                    newIntervals.add(new int[] {interval[0], left-1});    
                }
                if (right+1 <= interval[1]) {
                    newIntervals.add(new int[] {right+1, interval[1]});
                }
            } else {
                newIntervals.add(interval);
            }
        }
        
        intervals = newIntervals;
        
        // System.out.println("After removal: (" + left +", " + right + ")");
        // print();
    }
    
    void print() {
        for (int[] interval: intervals) {
            System.out.print(Arrays.toString(interval) + ", ");
        }
        
        System.out.println();
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */