class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = 301;
            }
        }
        
        for (int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (index < nums.length && nums[index] > 0) {
                nums[index] = -1 * nums[index];
            }
        }
        // System.out.println(Arrays.toString(nums));
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) {
                return i+1;
            }
        } 
        return nums.length + 1;
    }
}