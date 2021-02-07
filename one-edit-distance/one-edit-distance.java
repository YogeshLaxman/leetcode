class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        
        if(Math.abs(len1 - len2) > 1) {
            return false;
        }
        
        int i = 0;
        int j = 0;
        
        while(i < len1 && j < len2 && s.charAt(i) == t.charAt(j)) {
            i++;
            j++;
        }
        
        if(i == len1 && j == len2) {
            return false;
        }
        
        if(len1 > len2) {
            return s.substring(i + 1).equals(t.substring(j));
        } else if(len1 < len2) {
            return s.substring(i).equals(t.substring(j + 1));
        } else {
            return s.substring(i + 1).equals(t.substring(j + 1));
        }
    }
}