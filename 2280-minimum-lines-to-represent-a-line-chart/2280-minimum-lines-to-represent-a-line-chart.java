class Solution {
    public int minimumLines(int[][] stockPrices) {
        int n = stockPrices.length;
        if (n ==1) return 0;
        if (n <= 2) return 1;
        
        Arrays.sort(stockPrices, (a,b) -> a[0] - b[0]);
        int ans = 1;
        for (int i=2; i < stockPrices.length; i++) {
            int mNew = (stockPrices[i-1][1] - stockPrices[i][1]) / (stockPrices[i-1][0] - stockPrices[i][0]);
            
            int left = (stockPrices[i-1][1] - stockPrices[i][1]) * (stockPrices[i-2][0] - stockPrices[i-1][0]);
            int right = (stockPrices[i-1][0] - stockPrices[i][0]) * (stockPrices[i-2][1] - stockPrices[i-1][1]) ;
            if (left == right) {
                continue;
            } else {
                ans++;
            }
        } 
        
        return ans;
    }
}