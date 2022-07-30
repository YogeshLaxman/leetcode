class Solution {
    private int searchRangeStart(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                high = mid - 1;
                ans = mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
    private int searchRangeEnd(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                low = mid + 1;
                ans = mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int startIndex = searchRangeStart(nums, target);
        int endIndex = searchRangeEnd(nums, target);
        
        return new int[] {startIndex, endIndex};
    }
}