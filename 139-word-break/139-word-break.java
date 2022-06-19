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
        
        boolean ans = false;
        
        for (String word: wordDictSet) {
            if (s.indexOf(word, index) == index) {
                ans = ans || wordBreak(s, wordDictSet, index + word.length(), memo);
            }
        }
        
        return memo[index] = ans;
    }
}