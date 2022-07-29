class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] precedence = new int[26];
        
        for (int i=0; i < 26; i++) {
            char ch = order.charAt(i);
            precedence[ch - 'a'] = i;
        }
        
        for (int i=1; i<words.length; i++) {
            String previous = words[i-1];
            String current = words[i];
            
            if (!isPreviousLess(previous, current, precedence)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isPreviousLess(String previous, String current, int[] precedence) {
        int m = previous.length(), n = current.length();
        int p = 0, c = 0;
        
        while (p < m && c < n) {
            char pChar = previous.charAt(p);
            char cChar = current.charAt(c);
            
            if (precedence[pChar-'a'] > precedence[cChar-'a']) {
                return false;
            } else if (precedence[pChar-'a'] < precedence[cChar-'a']) {
                return true;
            }
            
            p++; c++;
        }
        
        return m <= n;
        
    }
}