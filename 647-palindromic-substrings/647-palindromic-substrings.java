class Solution {
    public int countSubstrings(String s) {
        int count = s.length();
        
        for (int i=0; i<s.length(); i++) {
            count += countSubstrings(s, i-1, i+1);
            count += countSubstrings(s, i, i+1);
        }
        
        return count;
    }
    public int countSubstrings(String s, int left, int right) {
        if (left < 0 || right >= s.length()) return 0;
        
        int count = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            } else {
                break;
            }
        }
        
        return count;
    }
}