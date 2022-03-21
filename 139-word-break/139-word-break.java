class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> cache = new HashMap<>();
        return wordBreakDP(s, wordDict, cache);
    }
    private boolean wordBreakDP(String s, List<String> wordDict, Map<String, Boolean> cache) {
        if(cache.containsKey(s)) {
            return cache.get(s);
        }
        String currentSubstring = "";
        for(int i=0; i < s.length(); i++) {
            currentSubstring = currentSubstring + s.charAt(i);
            if(wordDict.contains(currentSubstring)) {
                if(i+1 == s.length()) {
                    cache.put(s, true);
                    // System.out.println("here");
                    return true;
                } else {
                   if(wordBreakDP(s.substring(i+1), wordDict, cache)) {
                        cache.put(s.substring(i+1), true);
                        return true;   
                   }
                }
            }
        }
        cache.put(s, false);
        return false;
    }
}