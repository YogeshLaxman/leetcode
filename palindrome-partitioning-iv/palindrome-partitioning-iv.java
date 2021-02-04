class Solution {
    public boolean checkPartitioning(String s) {
        int length = s.length();
        char[] sChar = s.toCharArray();
        
        boolean[][] palindrome = new boolean[length][length];
        
        for (int i=0; i<length; i++) {
            for (int j=i; j<length; j++) {
                palindrome[i][j] = isPalindrome(sChar, i, j);
            }
        }
        
        for (int i=0; i<length; i++) {
            for (int j=i+1; j<=length-2; j++) {
                if (palindrome[0][i] && palindrome[i+1][j] && palindrome[j+1][length-1]) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean isPalindrome(char[] sChar, int i, int j) {
        while (i < j) {
            if (sChar[i] != sChar[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}