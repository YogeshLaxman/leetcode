class Solution {
    public int getMaxLen(int[] nums) {
        int max = 0;
        
        int low = 0;
        while (low < nums.length) {
            int high = low;
            while (low < nums.length && nums[low] == 0) {
                low++;
                high++;
            }

            while (high < nums.length && nums[high] != 0) {
                high++;
            }
            
            max = Math.max(max, getMaxLen(nums, low, high-1));
            low = high+1;
        }
        
        return max;
    }
    
    private int getMaxLen(int[] nums, int low, int high) {
        // System.out.println(low + ":" + high);
        int numberOfnegatives = 0, lastNegativeIndex = -1;
        
        for (int i=low; i<=high; i++) {
            if (nums[i] < 0) {
                numberOfnegatives++;
                lastNegativeIndex = i;
            }
        }
        
        int max = 0;
        for (int i=low; i<=high; i++) {
            if (numberOfnegatives % 2 == 0) {
                int current = high - i + 1;
                max = Math.max(max, current);
            } else {
                if (lastNegativeIndex != i) {
                    int current = lastNegativeIndex - i;
                    max = Math.max(max, current);
                }
            }
            if (nums[i] < 0) {
                numberOfnegatives--;
            }
        }
        
        return max;
    }
}