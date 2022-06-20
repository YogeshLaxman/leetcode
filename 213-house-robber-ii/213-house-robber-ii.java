class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        
        return Math.max(rob(nums, 1, n-1), rob(nums, 0, n-2));
    }
    
    private int rob(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        
        int lastPlusOne = 0;
        int last = nums[end];
        
        for (int i=end-1; i>=start; i--) {
            int current = Math.max(nums[i] + lastPlusOne, last);
            lastPlusOne = last;
            last = current;
        }
        
        return last;
    }
}