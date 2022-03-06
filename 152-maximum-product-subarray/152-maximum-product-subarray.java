class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[n-1];
        int min = nums[n-1];
        
        int ans = nums[n-1];
        
        for (int i=n-2; i>= 0; i--) {
            int temp1 = max * nums[i];
            int temp2 = min * nums[i];
            
            max = Math.max(temp1, temp2);
            min = Math.min(temp1, temp2);
            
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
            
            ans = Math.max(max, ans);
        }
        
        return ans;
    }
}