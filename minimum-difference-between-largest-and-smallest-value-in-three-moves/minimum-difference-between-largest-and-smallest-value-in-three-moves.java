class Solution {
    public int minDifference(int[] array) {
        int length = array.length;
        if (array.length <= 3 + 1) return 0;

        Arrays.sort(array);
        
        int min = Integer.MAX_VALUE;

        for  (int index = 0;  index <= 3; index++) {
            min = Math.min(array[length - (index + 1)] - array[3 - index], min);
        }

        return min;
    }
}