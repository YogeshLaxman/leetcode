class Solution {
    public String shortestPalindrome(String s) {
        char[] sChar = s.toCharArray();
        
        int right = sChar.length - 1;
        while (right >= 0) {
            boolean flag = true;
            int l = 0;
            int r = right;
            while (l <= r) {
                if (sChar[l] != sChar[r]) {
                    flag = false;
                }
                l++;
                r--;
            }
            if (flag) {
                break;
            }
            right--;
        }
        
        StringBuilder rem = new StringBuilder(s.substring(right+1));
        return rem.reverse().toString() + s;
    }
}