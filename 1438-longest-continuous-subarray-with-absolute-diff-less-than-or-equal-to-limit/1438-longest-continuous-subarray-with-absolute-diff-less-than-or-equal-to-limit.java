class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        
        int low = 0, high = 0, ans = 0;
        
        while (high < nums.length) {
            freqMap.put(nums[high], freqMap.getOrDefault(nums[high], 0) + 1);
            int lowestKey = freqMap.firstKey();
            int highestKey = freqMap.lastKey();
            
            while (highestKey - lowestKey > limit) {
                freqMap.put(nums[low], freqMap.get(nums[low]) - 1);
                if (freqMap.get(nums[low]) == 0) {
                    freqMap.remove(nums[low]);
                }
                lowestKey = freqMap.firstKey();
                highestKey = freqMap.lastKey();
                low++;
            }
            ans = Math.max(high - low + 1, ans);
            high++;
        }
        
        return ans;
    }
}