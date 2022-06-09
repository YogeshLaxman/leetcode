class Solution {
    public int maxArea(int[] height) {
        int low = 0, high = height.length - 1;
        
        int maxArea = 0;
        while (low < high) {
            int area = (high - low) * Math.min(height[low], height[high]);
            
            maxArea = Math.max(area, maxArea);
            
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        
        return maxArea;
    }
}