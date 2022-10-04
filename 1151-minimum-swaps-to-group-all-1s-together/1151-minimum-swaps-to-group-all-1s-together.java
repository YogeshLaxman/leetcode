class Solution {
    public int minSwaps(int[] data) {
        int n = data.length;
        
        int numOnes = 0;
        for (int i=0; i<n; i++) {
            if (data[i] == 1) {
                numOnes++;
            }
        }
        
        
        int currentWindow = 0;
        for (int i=0; i<numOnes; i++) {
            if (data[i] == 1) {
                currentWindow++;
            }
        }
        
        int maxInOneWindow = currentWindow;
        int low = 0, high = numOnes;
        
        while (high < n) {
            if (data[low] == 1) {
                currentWindow--;
            }
            if (data[high] == 1) {
                currentWindow++;
            }
            low++; high++;
            
            maxInOneWindow = Math.max(maxInOneWindow, currentWindow);
        }
        
        return numOnes - maxInOneWindow;
    }
}