class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            char currentChar = (char) ('A' + i);
            
            int low = 0, high = 0, currentAns = 0, done = k;
            
            while (high < s.length()) {
                if (s.charAt(high) == currentChar) {
                    currentAns++;
                    high++;
                } else if (done > 0) {
                    done--;
                    currentAns++;
                    high++;
                } else {
                    currentAns--;
                    if (s.charAt(low) != currentChar) {
                        done++;
                    }
                    low++;
                }
                ans = Math.max(ans, currentAns);
            }
            
            ans = Math.max(ans, currentAns);
        }
        
        return ans;
    }
}