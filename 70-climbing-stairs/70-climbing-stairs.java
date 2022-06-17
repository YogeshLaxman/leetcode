class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int firstTerm = 1, secondTerm = 2;
        
        for (int i=3; i<=n; i++) {
            int current = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = current;
        }
        
        return secondTerm;
    }
}