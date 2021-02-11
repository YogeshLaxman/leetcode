class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] m: matrix) {
            if (Arrays.binarySearch(m, target) >= 0) {
                return true;
            }
        }
        return false;
    }
}