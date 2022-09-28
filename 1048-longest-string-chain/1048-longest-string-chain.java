class Solution {
    Map<String, Integer> memo;
    public int longestStrChain(String[] words) {
        int ans = 0;
        memo = new HashMap<>();
        for (int i=0; i<words.length; i++) {
            ans = Math.max(ans, longestStrChain(words, words[i]));
        }
        
        return ans;
    }
    
    
    public int longestStrChain(String[] words, String currentWord) {
        if (memo.containsKey(currentWord)) {
            return memo.get(currentWord);
        }
        
        int ans = 1;
        for (int i=0; i<words.length; i++) {
            if (isPredecessor(currentWord, words[i])) {
                ans = Math.max(ans, 1 + longestStrChain(words, words[i]));
            }
        }
        // System.out.println(currentWord + ":" + ans);
        memo.put(currentWord, ans);
        return ans;
    }
    
    private boolean isPredecessor(String first, String second) {
        if (second.length() - first.length() != 1) return false;
        
        int firstIndex = 0, secondIndex = 0;
        boolean oneExtraCharUsed = false;
        while (firstIndex < first.length() && secondIndex < second.length()) {
            if (first.charAt(firstIndex) == second.charAt(secondIndex)) {
                firstIndex++; secondIndex++;
            } else if (oneExtraCharUsed) {
                return false;
            } else {
                oneExtraCharUsed = true;
                secondIndex++;
            }
        }
        
        return true;
    }
}