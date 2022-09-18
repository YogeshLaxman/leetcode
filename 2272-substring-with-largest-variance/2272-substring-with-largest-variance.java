class Solution {
    public int largestVariance(String s) {
        int ans = 0;
        for (int i=0; i<26; i++) {
            for (int j=0; j<26; j++) {
                ans = Math.max(ans, findMax(s, i, j));
            }
        }
        
        return ans;
    }
    
    private int findMax(String s, int maxChar, int minChar) {
        if (maxChar == minChar) return 0;
        
        int maxAns = 0;
        
        int maxCount = 0, minCount = 0;
        int low = 0, high = 0;
        
        while (high < s.length()) {
            if (s.charAt(high) == minChar + 'a') {
                minCount++;
                while (low < high && minCount > 1) {
                    if (s.charAt(low) == minChar + 'a') {
                        minCount--;
                    } else if (s.charAt(low) == maxChar + 'a') {
                        break;
                    }
                    low++;
                }
                
                if (minCount > maxCount) {
                    minCount = 1;
                    maxCount = 0;
                    low = high;
                }
            }

            if (s.charAt(high) == maxChar + 'a') {
                maxCount++;
                
            }
            
            if (minCount > 0) {
                maxAns = Math.max(maxAns, maxCount - minCount);
            }

            high++;
        }
        
        return maxAns;
    }
}