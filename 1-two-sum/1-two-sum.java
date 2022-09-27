class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> elementToIndexMap = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            int rem = target - nums[i];
            if (elementToIndexMap.containsKey(rem)) {
                return new int[] {elementToIndexMap.get(rem), i};
            }    
            elementToIndexMap.put(nums[i], i);
            
        }
        
        return null;
    }
}