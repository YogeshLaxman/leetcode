class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        
        int[] left = new int[n];
        int prev = -1;
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == '|') {
                prev = i;
            }
            left[i] = prev;
        }
        
        int[] right = new int[n];
        prev = -1;
        for (int i=n-1; i>=0; i--) {
            if (s.charAt(i) == '|') {
                prev = i;
            }
            right[i] = prev;
        }
        
        int[] prefixSum = new int[n];
        int sum = 0;
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == '*') {
                sum += 1;
            }
            prefixSum[i] = sum;
        }
        
        int m = queries.length;
        int[] result = new int[m];
        
        for (int i=0; i<m; i++) {
            int leftIndex = right[queries[i][0]];
            int rightIndex = left[queries[i][1]];
            
            if (leftIndex == -1 || rightIndex == -1 || leftIndex >= rightIndex) {
                continue;
            }
            
            result[i] = prefixSum[rightIndex] - prefixSum[leftIndex];
        }
        
        return result;
    }
}