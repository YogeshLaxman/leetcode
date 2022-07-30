class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        
        int[] ans = new int[n];
        
        int i = -1, j = n;
        if (nums[0] >= 0) {
            j = 0;
        } else if (nums[n-1] <= 0) {
            i = n - 1;
        } else {
            i = 0;
            j = 1;
            while (true) {
                if (nums[i] < 0 && nums[j] < 0) {
                    i++; j++;
                } else {
                    break;
                }
            }    
        }
        
        
        
        int index = 0;
        while (i >= 0 && j < n) {
            if (Math.abs(nums[i]) < Math.abs(nums[j])) {
                ans[index++] = nums[i] * nums[i];
                i--;
            } else {
                ans[index++] = nums[j] * nums[j];
                j++;
            }
        }
        
        while (i >= 0) {
            ans[index++] = nums[i] * nums[i];
            i--;
        }
        
        while (j < n) {
            ans[index++] = nums[j] * nums[j];
                j++;
        }
        
        return ans;
    }
}