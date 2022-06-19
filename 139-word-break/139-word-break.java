class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        Set<String> wordDictSet = new HashSet<>(wordDict);
        
        
        return wordBreak(s, wordDictSet, 0, memo);
    }
    
    private boolean wordBreak(String s, Set<String> wordDictSet, int index, Boolean[] memo) {
        if (index == s.length()) return true;
        
        if (memo[index] != null) {
            return memo[index];
        }
        
        StringBuilder substring = new StringBuilder("");
        boolean ans = false;
        
        for (int i=index; i<s.length(); i++) {
            substring.append(s.charAt(i));
            // System.out.println(substring);
            if (wordDictSet.contains(substring.toString())) {
                ans = ans || wordBreak(s, wordDictSet, i+1, memo);
            }
        }
        
        return memo[index] = ans;
    }
}