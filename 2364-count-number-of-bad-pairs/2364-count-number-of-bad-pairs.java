class Solution {
    public long countBadPairs(int[] nums) {
        /* (4-1) - (1 - 0) = 2
            (4 - 3) - (2 - 0) = -1
            (4-3) - (3 - 0) = -2
            
            (4-1) -1 = 2
            (4 - 3) - 2 = -1
            ()
        */  
        
        int n = nums.length;
        int[] memo = new int[n];
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        long badPairs = 0l;
        for (int i=1; i<n; i++) {
            memo[i] = (nums[i] - nums[0]) - (i - 0);
            
            freqMap.put(memo[i], freqMap.getOrDefault(memo[i], 0) + 1);
            
            if (memo[i] != 0) {
                badPairs++;
            }
        }
        
        // System.out.println(freqMap);
        
        
        for (int i=1; i<n; i++) {
            freqMap.put(memo[i], freqMap.get(memo[i]) - 1);
            
            // System.out.println(freqMap);
            
            int diff = (nums[0] - nums[i]) + (i);
            diff = -1 * diff;
            
            
            int sub = freqMap.getOrDefault(diff, 0);
            
            // System.out.println(diff + ":" + sub);
            
            
            
            badPairs = badPairs + (n - i - 1) - sub;
        }
        
        return badPairs;
    }
}