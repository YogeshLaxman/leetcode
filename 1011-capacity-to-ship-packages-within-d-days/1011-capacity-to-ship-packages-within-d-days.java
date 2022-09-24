class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        for (int w: weights) {
            sum += w;
        }
        
        int high = sum, low = 1;
        
        int min = sum;
        while (low <= high) {
            int mid = low + (high-low) / 2;
            
            boolean possible = isPossible(weights, days, mid);
            
            if (possible) {
                // System.out.println(mid);
                min = Math.min(min, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return min;
    }
    
    private boolean isPossible(int[] weights, int days, int capacity) {
        int current = 0;
        int currentDay = 1;
        for(int w: weights) {
            // System.out.println(current + ":" + days);
            if (w > capacity) {
                return false;
            }
            if (current + w > capacity) {
                if (currentDay + 1 > days) return false;
                currentDay++;
                current = 0;
            }
            
            current += w;
        }
        
        return true;
    }
}