class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        int firstIndex = -1, seconIndex = -1;
        int numberOfMisMatches = 0;
        int[] freq= new int[26];
        
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                numberOfMisMatches++;
                if (numberOfMisMatches > 2) {
                    return false;
                }
                if (numberOfMisMatches == 1) {
                    firstIndex = i;
                }
                 if (numberOfMisMatches == 2) {
                    seconIndex = i;
                }
            }
            freq[s.charAt(i) - 'a']++;
        }
        if (numberOfMisMatches == 1) return false;
        
        if (numberOfMisMatches == 0) {
            for (int i=0; i<26; i++) {
                if (freq[i] > 1) return true;
            }
            return false;
        }
        
        return s.charAt(firstIndex) == goal.charAt(seconIndex) && s.charAt(seconIndex) == goal.charAt(firstIndex);
    }
}