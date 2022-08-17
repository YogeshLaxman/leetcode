/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    private int binarySerach(BinaryMatrix binaryMatrix, int currentRow, int length) {
        int low = 0, high = length-1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midElement = binaryMatrix.get(currentRow, mid);
            
            if (midElement == 0) {
                low = mid+1;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
        
    }
    
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0), cols = dimensions.get(1);
        
        int min = cols + 1;
        for (int i=0; i<rows; i++) {
            int currentColIndex = binarySerach(binaryMatrix, i, cols);
            // System.out.println(currentColIndex);
            if (currentColIndex != -1) {
                min = Math.min(min, currentColIndex);
            }
        }
        
        return min >= cols ? -1 : min;
    }
}