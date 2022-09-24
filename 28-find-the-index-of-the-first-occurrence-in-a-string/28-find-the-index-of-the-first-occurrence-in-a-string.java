class Solution {
    public int strStr(String haystack, String needle) {
        for (int i=0; i<haystack.length(); i++) {
            boolean matched = true;
            if (i+needle.length()-1 >= haystack.length()) {
                continue;
            }
            for (int j=0; j<needle.length() && i+j<haystack.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    matched = false;
                    break;
                }
            }
            
            if (matched) return i;
        }
        
        return -1;
        
    }
}