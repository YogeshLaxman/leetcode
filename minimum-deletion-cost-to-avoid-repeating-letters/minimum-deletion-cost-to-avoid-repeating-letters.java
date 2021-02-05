class Solution {
    public int minCost(String s, int[] cost) {
        char prev = s.charAt(0);
        int maxCost = cost[0];
        
        int ans = 0;
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) == prev) {
                ans += Math.min(maxCost, cost[i]);
                maxCost = Math.max(maxCost, cost[i]);
            } else {
                maxCost = cost[i];
            }
            prev = s.charAt(i);
        }
        
        return ans;
    }
}