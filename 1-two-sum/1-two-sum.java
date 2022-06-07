class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        
        for (int i=0; i<nums.length; i++) {
            int rem = target - nums[i];
            
            if (seen.containsKey(rem)) {
                return new int[] {i, seen.get(rem)};
            } 
            
            seen.put(nums[i], i);
        }
        
        return null;
    }
}