class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        
        int ones = 0;
        
        int flips = 0;
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == '0') {
                flips = Math.min(ones, flips+1);
            } else {
                ones++;
            }
        }
        
        return flips;
    }
}