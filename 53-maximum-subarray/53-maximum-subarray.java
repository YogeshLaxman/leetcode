class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i=1; i<nums.length; i++) {
            currentSum += nums[i];
            if (currentSum < nums[i]) {
                currentSum = nums[i];
            }
            
            maxSum = Math.max(currentSum, maxSum);
        }
        
        return maxSum;
    }
}