class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        for (int i=0; i<nums.length; i++) {
            max = Math.max(max, nums[i]);
            int product = nums[i];
            for (int j=i+1; j<nums.length; j++) {
                product *= nums[j];
                max = Math.max(max, product);
            }
        }
        
        return max;
    }
}