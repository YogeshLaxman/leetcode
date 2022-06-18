class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        int min = coinChange(coins, amount, memo);
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private int coinChange(int[] coins, int amount, int[] memo) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        
        if (memo[amount] != 0) {
            return memo[amount];
        }
        
        int min = Integer.MAX_VALUE;
        for (int i=0; i<coins.length; i++) {
            min = Math.min(coinChange(coins, amount - coins[i], memo), min);
        }
        
        return memo[amount] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE: min + 1;
    }
}