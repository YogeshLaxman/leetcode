class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        
        int max = 0;
        for (int i=0; i<n; i++) {
            max = Math.max(max, piles[i]);
        }
        
        int low = 1, high = max;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            int totalHours = 0;
            for (int i=0; i<n; i++) {
                totalHours += (int) Math.ceil(1.0 * piles[i] / mid);
            }
            // System.out.println(mid + ":" + totalHours);
            if (totalHours <= h) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}