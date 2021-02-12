class Solution {
    public int findDuplicate(int[] nums) {
        for (int num: nums) {
            if (nums[Math.abs(num)] < 0) {
                return Math.abs(num);
            } else {
                nums[Math.abs(num)] = -1 * nums[Math.abs(num)];
            }
        }
        return -1;
    }
}