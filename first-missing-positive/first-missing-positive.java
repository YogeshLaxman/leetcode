class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] array = new int[301];
        for (int num: nums) {
            if (num > 0) {
                if (num < array.length) {
                    array[num] = -1;    
                }
            }
        }
        for (int i=1; i<=300; i++) {
            if (array[i] == 0) {
                return i;
            }
        }
        return 301;
    }
}