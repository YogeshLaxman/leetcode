class Solution {
    int[][] memo;
    
    private int change(int amount,int[] coins, int index) {
        // System.out.println(amount + ":" + index);
        
        if (amount < 0 || index == coins.length) return 0;
        
        if (memo[index][amount] != -1) return memo[index][amount];
        
        if (amount - coins[index] == 0) {
            return 1;
        }
        
        memo[index][amount] = 0;
        for (int i=index; i<coins.length; i++) {
            memo[index][amount] += change(amount - coins[index], coins, i);    
        }
        
        return memo[index][amount];
    }
    
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        memo = new int[coins.length][amount+1];
        for (int[] item: memo) {
            Arrays.fill(item, -1);
        }
    
        if (amount == 0) return 1;
        
        int ans = 0;
        for (int i=0; i<coins.length; i++) {
            ans += change(amount, coins, i);    
        }
        
        return ans;
    }
}