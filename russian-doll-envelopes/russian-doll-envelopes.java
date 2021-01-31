class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (e1, e2) -> {
           return e1[0] - e2[0]; 
        });
    
        int[] dp = new int[envelopes.length];
        int max = 0;
        for (int i=envelopes.length-1; i>=0; i--) {
            int ans = 1;
            for (int j=i+1; j<dp.length; j++) {
                if (envelopes[i][0] < envelopes[j][0] && envelopes[i][1] < envelopes[j][1]) {
                    ans = Math.max(ans, 1+dp[j]);
                }
            }
            dp[i] = ans;
            max= Math.max(max, ans);
        }
        
        return max;
    }
}