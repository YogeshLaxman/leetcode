class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i=1; i<=amount; i++) {
            for (int coin: coins) {
                if (coin > i) {
                    break;
                }
                for(int j=1; j<=i/coin; j++) {
                    
                    int rem = i - j * coin;
                    // System.out.println(rem);
                    if (dp[rem] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], j + dp[rem]);    
                    }
                }
                
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}