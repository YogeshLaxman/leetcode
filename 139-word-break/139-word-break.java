class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] memo = new boolean[n+1];
        memo[n] = true;
        
        Set<String> wordDictSet = new HashSet<>(wordDict);
        
        for (int i=n-1; i>=0; i--) {
            StringBuilder left = new StringBuilder();
            for (int j=i; j<n; j++) {
                left = left.append(s.charAt(j));
                if (wordDictSet.contains(left.toString())) {
                    memo[i] = memo[i] || memo[j+1];
                }
                if (memo[i]) break;
            }
        }
        
        return memo[0];
    }
}