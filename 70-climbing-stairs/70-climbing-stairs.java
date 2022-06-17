class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return climbStairs(n, memo);
    }
    
    private int climbStairs(int n, int[] memo) {
        if (n <= 1) return 1;
        if (memo[n] != -1) return memo[n];
        return memo[n] = climbStairs(n-1, memo) + climbStairs(n-2, memo);
    }
}