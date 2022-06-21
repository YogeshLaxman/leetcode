class Solution {
    public int uniquePaths(int m, int n) {
        int min = Math.min(m, n);
        int max = Math.max(m, n);
        
        int[] dp = new int[min];
        Arrays.fill(dp, 1);
        
        for (int i=0; i<max-1; i++) {
            for (int j=min-2; j>=0; j--) {
                dp[j] = dp[j] + dp[j+1];
            }
            // System.out.println(Arrays.toString(dp));
        }
        
        return dp[0];
    }
}