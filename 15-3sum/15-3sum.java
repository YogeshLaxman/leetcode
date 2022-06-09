class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
       List<List<Integer>> ans = new ArrayList<>();
        for (int i=0; i < nums.length; i++) {
            if (i>0 && nums[i-1] == nums[i]) {
                continue;
            }
            int low = i + 1, high = nums.length - 1;
            
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    while (low < high && nums[low] == nums[low-1])
                        low++; 
                } else if (sum > 0) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        
        return ans;
    }
}