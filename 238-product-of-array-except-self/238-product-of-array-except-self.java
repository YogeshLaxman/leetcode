class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        
        Arrays.fill(ans, 1);
        
        int product = 1;
        for (int i=0; i<len; i++) {
            ans[i] = ans[i] * product;
            product = product * nums[i];
        }
        
        product = 1;
        for (int i=len-1; i>=0; i--) {
            ans[i] *= product;
            product *= nums[i];
        }
        
        return ans;
    }
}