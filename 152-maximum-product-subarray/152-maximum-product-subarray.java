class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        
        int ans = max;
        for (int i=1; i<nums.length; i++) {
            int prod1 = max * nums[i];
            int prod2 = min * nums[i];
            
            max = Math.max(prod1, prod2);
            max = Math.max(max, nums[i]);
            
            min = Math.min(prod1, prod2);
            min = Math.min(min, nums[i]);
            
            ans = Math.max(max, ans);
        }
        
        return ans;
    }
}