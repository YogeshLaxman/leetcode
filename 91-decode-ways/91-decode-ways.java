class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int n = s.length();
        int start = 0;
        
        return numDecodingsDP(s);
    }
    
    private int numDecodingsDP(String s) {
        // System.out.println("Called");
        if (s.length() == 1) return 1;
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return numDecodingsDP(s, 0, memo);
    }
    
    private int numDecodingsDP(String s, int index, int[] memo) {
        if (index >= s.length()) return 1;
        if (s.charAt(index) == '0') return 0;
        if (memo[index] != -1) return memo[index];
        
        int ans = numDecodingsDP(s, index+1, memo);
        if (index+1 < s.length()) {
            int num = (s.charAt(index) - '0') * 10 + (s.charAt(index+1) - '0');
            if (num >= 1 && num <= 26) {
                ans += numDecodingsDP(s, index+2, memo);
            }    
        }
        
        
        return memo[index] = ans;
    }
}