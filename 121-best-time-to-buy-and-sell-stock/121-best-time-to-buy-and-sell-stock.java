class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int max = prices[len-1];
        
        int ans = 0;
        for (int i=len-1; i>=0; i--) {
            int currentDiff = max - prices[i];
            
            ans = Math.max(ans, currentDiff);
            
            max = Math.max(prices[i], max);
        }
        
        return ans;
    }
}