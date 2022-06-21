class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lastTrue = n - 1;
        
        for (int i=n-2; i>=0; i--) {
            if (i + nums[i] >= lastTrue) {
                lastTrue = i;
            }
        }
        
        return lastTrue == 0;
    }
}