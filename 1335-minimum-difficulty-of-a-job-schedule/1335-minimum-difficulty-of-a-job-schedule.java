class Solution {
    int[][] memo;
    
    public int minDifficulty(int[] jobDifficulty, int d) {
        memo = new int[jobDifficulty.length][d+1];
        for (int[] item: memo) {
            Arrays.fill(item, -1);
        }
        
        int ans = minDifficulty(jobDifficulty, d, 0); 
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private int minDifficulty(int[] jobDifficulty, int d, int index) {
        if (index == jobDifficulty.length && d == 0) {
            return 0;
        }
        
        if (index == jobDifficulty.length || d == 0) {
            return Integer.MAX_VALUE;
        }
        
        if (memo[index][d] != -1) {
            return memo[index][d];
        }
        
        int currentDayMax = 0;
        int ans = Integer.MAX_VALUE;
        for (int i=index; i<jobDifficulty.length; i++) {
            currentDayMax = Math.max(currentDayMax, jobDifficulty[i]);
            int remDifficulity = minDifficulty(jobDifficulty, d-1, i+1);
            if (remDifficulity != Integer.MAX_VALUE)  {
                ans = Math.min(ans, remDifficulity + currentDayMax);
            }
        }
        
        return memo[index][d] = ans;
    }
}