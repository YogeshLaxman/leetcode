class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0; i<k; i++) {
            while (!list.isEmpty() && nums[i] > list.getLast()) list.removeLast();
            list.addLast(nums[i]);
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = list.getFirst();
        
        int low=0, high = k;
        while(high < nums.length) {
            if (nums[low++] == list.getFirst()) {
                list.removeFirst();
            }
            while (!list.isEmpty() && nums[high] > list.getLast()) list.removeLast();
            list.addLast(nums[high++]);
            
            ans[low] = list.getFirst();
        }
        
        return ans;
    }
}