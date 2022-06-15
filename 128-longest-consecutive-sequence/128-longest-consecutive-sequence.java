class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num: nums) {
            numsSet.add(num);    
        }
        
        int max = 0;
        for (int num: nums) {
            if (!numsSet.contains(num-1)) {
                int current = 0;
                while (numsSet.contains(num)) {
                    current++;
                    num++;
                }
                max = Math.max(current, max);
            }
        }
        
        return max;
    }
}