class Solution {
    int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return wordBreak(s, new HashSet<>(wordDict), 0);
    }
    
    public boolean wordBreak(String s, Set<String> wordDict, int index) {
        if (index == s.length()) return true;
        if (memo[index] != -1) return memo[index] == 1;
        StringBuilder sb = new StringBuilder();
        boolean ans = false;
        for (int i=index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (wordDict.contains(sb.toString())) {
                ans = ans || wordBreak(s, wordDict, i+1);
            }
            if (ans) {
                break;
            }
        }
        memo[index] = ans ? 1 : 0;
        
        return ans;
    }
}