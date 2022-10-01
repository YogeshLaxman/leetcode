class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] timeWindows = new boolean[24*60];
        
        int minTime = Integer.MAX_VALUE;
        for (String time: timePoints) {
            int h = Integer.parseInt(time.substring(0,2));
            int m = Integer.parseInt(time.substring(3));
            
            int timeInMins = h*60+m;
            if (timeWindows[timeInMins]) {
                return 0;
            }
            timeWindows[timeInMins] = true;
            
            minTime= Math.min(timeInMins, minTime);
            
        }
        
        int ans = Integer.MAX_VALUE;
        int prev = minTime;
        for (int i=minTime+1; i<24*60; i++) {
            if (timeWindows[i]) {
                int diff = i - prev;
                prev = i;
                ans = Math.min(ans, diff);
            }
        }
        
        minTime += 24*60;
        ans = Math.min(ans, minTime - prev);
        
        return ans;
    }
}