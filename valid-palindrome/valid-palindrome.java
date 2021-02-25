class Solution {
    public boolean isPalindrome(String s) {
        char[] sChar = s.toLowerCase().toCharArray();
        int left = 0, right = sChar.length - 1;
        
        while (left < right) {
            while(!Character.isAlphabetic(sChar[left]) && !Character.isDigit(sChar[left]) && left < right) {
                left++;
            }
            while(!Character.isAlphabetic(sChar[right]) && !Character.isDigit(sChar[right]) && left < right) {
                right--;
            }
            if (left < right) {
                if (sChar[left] != sChar[right]) {
                    return false;
                }
            }
            left++; right--;
        }
        
        return true;
    }
}