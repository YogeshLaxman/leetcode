class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n==1) return nums[0];
        if (n==2) return Math.max(nums[0], nums[1]);
        int second = nums[n-1], first = Math.max(nums[n-1], nums[n-2]);
        
        for (int i=nums.length-3; i>=0; i--) {
            int current = Math.max(nums[i] + second, first);
            second = first;
            first = current;
        }
        
        return first;
    }
}