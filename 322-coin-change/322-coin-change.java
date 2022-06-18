class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[coins.length+1][amount+1];
        for (int[] item: memo) {
            Arrays.fill(item, -1);
        }
        int min = Integer.MAX_VALUE;
        
        for (int i=0; i<coins.length; i++) {
            min = Math.min(coinChange(coins, amount, i, memo), min);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private int coinChange(int[] coins, int amount, int index, int[][] memo) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (index > coins.length) return Integer.MAX_VALUE;
        
        if (memo[index][amount] != -1) {
            return memo[index][amount];
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i=index; i<coins.length; i++) {
            min = Math.min(coinChange(coins, amount - coins[index], i, memo), min);
        }
        
        return memo[index][amount] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE: min + 1;
    }
}