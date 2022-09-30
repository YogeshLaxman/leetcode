class Solution {
    long[][] memo;
    public long maxPoints(int[][] points) {
        
        int m = points.length, n = points[0].length;
        // System.out.println(m + ":" + n);
        
        
        long[] memo = new long[n];
        
        for (int i=0; i<m; i++) {
            long[] left = new long[n];
            left[0] = memo[0];
            
            long[] right = new long[n];
            right[n-1] = memo[n-1];
            
            for (int j=1; j<n; j++) {
                left[j] = Math.max(left[j-1]-1, memo[j]);
            }
            // System.out.println(Arrays.toString(left));
            
            for (int j=n-2; j>=0; j--) {
                right[j] = Math.max(right[j+1]-1, memo[j]);
            }
            // System.out.println(Arrays.toString(right));
            for (int j=0; j<n; j++) {
                memo[j] = Math.max(left[j], right[j]) + points[i][j];
            }
            
            // System.out.println(Arrays.toString(memo));
        }
        
        long max = 0;
        for (int j=0; j<n; j++) {
            max = Math.max(max, memo[j]);
        }
        
        return max;
    }
}