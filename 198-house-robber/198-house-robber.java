class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length+1];
        Arrays.fill(memo, -1);
        
        return rob(nums, 0, memo);
    }
    
    private int rob(int[] nums, int index, int[] memo) {
        if (index >= nums.length) return 0;
        if (memo[index] != -1) return memo[index];
        return memo[index] = Math.max(nums[index] + rob(nums, index+2, memo), rob(nums, index+1, memo));
        
        
    }
}