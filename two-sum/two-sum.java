class Solution {
    public int[] twoSum(int[] nums, int target) {
     
        Map<Integer,Integer> hs = new HashMap<>();
        
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        
        hs.put(target - nums[0], 0);
        
        for(int i = 1 ; i < nums.length ; i++ ){
            
            int compliment = target - nums[i];
            
            if(hs.containsKey(nums[i])){
                result[0] = hs.get(nums[i]);
                result[1] = i;
                return result;
            }else{
                 hs.put(target - nums[i], i);
            }
            
        }
        
        System.out.println(hs);
        return result;
         
    }
}
