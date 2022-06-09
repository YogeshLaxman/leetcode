class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        while (low < high) {
            int mid = (low + high) / 2;
            
            boolean leftSideIncreasing = nums[low] < nums[mid];
            boolean rightSideIncreasing = nums[mid] < nums[high];
            
            if (leftSideIncreasing && rightSideIncreasing) {
                break;
            }
            
            if (!leftSideIncreasing && !rightSideIncreasing) {
                low = mid + 1;
            } 
            
            if (leftSideIncreasing) {
                low = mid + 1;
            }
            
            if (rightSideIncreasing) {
                high = mid;
            }
        }
        
        return nums[low];
    }
}