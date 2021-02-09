class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
    
        int max = 0;
        for (int i=0; i<n; i++) {
            left[i] = max;
            max = Math.max(height[i], max);
        }
        
        max = 0;
        for (int i=n-1; i>=0; i--) {
            right[i] = max;
            max = Math.max(height[i], max);
        }
        
        int trapped = 0;
        
        for (int i=0; i<n; i++) {
            if (height[i] < Math.min(left[i], right[i])) {
                trapped += Math.min(left[i], right[i]) - height[i];
            }
        }
        
        return trapped;
    }
}