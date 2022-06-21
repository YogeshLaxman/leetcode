class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (s.charAt(0) == '0') return 0;
        if (n == 1) return 1;

        int last = s.charAt(n-1) == '0' ? 0 : 1;
        int lastPlusOne = 1;
        
        for (int i=n-2; i>=0; i--) {
            int current = 0;
            if (s.charAt(i) != '0') {
                current = last;
                if (Integer.parseInt(s.substring(i, i+2)) <= 26) {
                    current += lastPlusOne;
                } 
            }
            
            lastPlusOne = last;
            last = current;
        }
        
        return last;
    }
}