class Solution {
    int last0Index = -1;
    int last1Index = -1;
    int last2Index = -1;
    int[] nums;
    public void sortColors(int[] nums) {
        this.nums = nums;
        
        for (int i=0; i<nums.length; i++) {
            
            if (nums[i] == 0) {
                shift1();
                nums[++last0Index] = 0;
                last1Index = Math.max(last1Index, last0Index);
                last2Index = Math.max(last1Index, last2Index);
            } else if (nums[i] == 1) {
                shift2();
                nums[++last1Index] = 1;
                last2Index = Math.max(last1Index, last2Index);
            } else if (nums[i] == 2) {
                nums[++last2Index] = 2;
            }
            
            // System.out.println(Arrays.toString(nums));
            // System.out.println(last0Index + ":" + last1Index + ":" + last2Index);
        }
    }
    
    void shift1() {
        shift2();
        
        if (last1Index == -1 || nums[last1Index] != 1) return;
        nums[++last1Index] = 1;
    }
    
    void shift2() {
        if (last2Index == -1 || nums[last2Index] != 2) return;
        nums[++last2Index] = 2;
    }
}