class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int maxTime = 0;
        for (int t : time) {
            maxTime = Math.max(maxTime, t);
        }
        
        long high = 1l * maxTime * totalTrips;
        
        long low = 1;
        
        long min = Long.MAX_VALUE;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            boolean possible = isPossible(time, mid, totalTrips);
            
            if (possible) {
                min = Math.min(mid, min);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return min;
    }
    
    private boolean isPossible(int[] time, long mid, long totalTrips) {
        
        for (int t: time) {
            totalTrips -= (mid / t);
            if (totalTrips <= 0) {
                return true;
            }
        }
        
        return false;
    }
}