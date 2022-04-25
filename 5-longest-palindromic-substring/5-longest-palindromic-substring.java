class Solution {

    String longPalindorme = new String("");
    public String longestPalindrome(String s) {    
        for (int i=0; i<s.length(); i++) {
            palindorme(s, i, i);
            palindorme(s, i, i+1);
        }
        return longPalindorme;
    }
    
    private void palindorme(String s, int low, int high) {
        while (low >= 0 && high < s.length()) {
            if (s.charAt(low) == s.charAt(high)) {
                low--; high++;
            } else {
                break;
            }
        }
        low++; high--;
        int len = high - low + 1;
        if (len > longPalindorme.length()) {
            longPalindorme = s.substring(low , high+1);
        }
    }
}