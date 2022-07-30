class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans = combinationSum(candidates, target, 0, 0);
        return ans == null ? new ArrayList<>() : ans;
    }
    
    private List<List<Integer>> combinationSum(int[] candidates, int target, int currentSum, int currentIndex) {
        if (currentSum == target) {
            // System.out.println(currentIndex);
            List<List<Integer>> ans = new ArrayList<>(); 
            ans.add(new ArrayList<>());
            return ans;
        }
        
        if (currentSum > target) return null;
        
        List<List<Integer>> ans = new ArrayList<>();
        if (currentIndex == candidates.length) return null;
        
        
        for (int i=currentIndex; i<candidates.length; i++) {
            List<List<Integer>> currentAns = combinationSum(candidates, target, currentSum+candidates[i], i);
            if (currentAns != null) {
                // System.out.println(currentAns.size());
                for (List<Integer> item: currentAns) {
                    item.add(candidates[i]);
                    ans.add(item);
                    // System.out.println(ans);
                }    
            }
            
        }
        
        return ans.size() == 0 ? null : ans;
        
    }
}