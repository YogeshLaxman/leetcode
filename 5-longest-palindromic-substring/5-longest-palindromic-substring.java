class Solution {

    int lowAns = 0, highAns = 0;
    public String longestPalindrome(String s) {    
        for (int i=0; i<s.length(); i++) {
            palindorme(s, i, i);
            palindorme(s, i, i+1);
        }
        return s.substring(lowAns, highAns+1);
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
        if (len > highAns - lowAns + 1) {
            lowAns = low; highAns = high;
        }
    }
}