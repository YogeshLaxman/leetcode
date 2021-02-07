class Solution {
    public int maximumScore(int a, int b, int c) {
        int[] nums = {a,b,c};
        Arrays.sort(nums);
        
        int sum = nums[0] + nums[1];
        
        if (sum >= nums[2]) {
            return nums[2] + (nums[0]+nums[1]-nums[2])/2;
        } else {
            return sum;
        }
    }
}