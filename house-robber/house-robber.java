class Solution {
    public int rob(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;
        
        for(int i = nums.length - 1; i >=0; i--) {
            int temp = prev1;
            prev1 = Math.max(prev2 + nums[i], prev1);
            prev2 = temp;
        }
        return prev1;
    }
}