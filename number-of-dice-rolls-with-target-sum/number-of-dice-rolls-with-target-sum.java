class Solution {
    int MODULU = 1000000007;
    
    int[][] memo;
    public int numRollsToTarget(int d, int f, int target) {
        memo = new int[d+1][target+1];
        for (int[] m: memo) {
            Arrays.fill(m, -1);
        }
        
        return numRollsToTargetDP(d, f, target);
        
    }
    
    private int numRollsToTargetDP(int d, int f, int target) {
        if (d == 0 && target == 0) {
            return 1;
        }
        
        if (target < 0 || d < 0) {
            return 0;
        }
        
        if (memo[d][target] != -1) {
            return memo[d][target];
        }
        int ans = 0;
        for (int i=1; i<=f; i++) {
            ans = (ans + numRollsToTargetDP(d-1, f, target-i)) % MODULU;
        }
        
        memo[d][target] = ans;
        return ans;
    }
}