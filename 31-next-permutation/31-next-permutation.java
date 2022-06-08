class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length == 1) return;
        
        int index = length - 1;
        while (index > 0) {
            if (nums[index-1] < nums[index]) {
                break;
            }
            index--;
        }
        
        if (index == 0) {
            reverse(nums, 0);
            return;
        }
        reverse(nums, index);
        
        for (int i=index; i<nums.length; i++) {
            if (nums[i] > nums[index-1]) {
                int temp = nums[i]; 
                nums[i] = nums[index-1];
                nums[index-1] = temp;
                break;
            }
        }
    }
    
    private void reverse(int[] nums, int startIndex) {
        int low = startIndex;
        int high = nums.length - 1;
        
        while (low < high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            
            low++; high--;
        }
        
    }
}