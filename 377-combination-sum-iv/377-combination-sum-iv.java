class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target+1];
        Arrays.fill(memo, -1);
        
        return combinationSum4(nums, target, memo);
    }
    
    public int combinationSum4(int[] nums, int target, int[] memo) {
        if (target == 0) return 1;
        
        if (memo[target] != -1) {
            return memo[target];
        }
        
        int ans = 0;
        for (int num: nums) {
            if (num <= target) {
                ans += combinationSum4(nums, target-num, memo);
            }
        }
        
        return memo[target] = ans;
    }
}