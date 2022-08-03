class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] difficultProfitArray = new int[n][3];        
        
        for (int i=0; i<n; i++) {
            difficultProfitArray[i][0] = difficulty[i];
            difficultProfitArray[i][1] = profit[i];
        }
        
        Arrays.sort(difficultProfitArray, (a,b) -> {
           return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]; 
        });
        
        int max = 0;
        
        for (int i=0; i<n; i++) {
            max = Math.max(difficultProfitArray[i][1], max);
            difficultProfitArray[i][2] = max;
        }
        
        System.out.println(Arrays.deepToString(difficultProfitArray));
        
        int ans = 0;
        for (int skill: worker) {
            int[] toSearch = {skill, 0, 0};
            int index = Arrays.binarySearch(difficultProfitArray, toSearch, (a, b) -> {
                return a[0] - b[0];
            });
            
            if (index >= 0) {
                ans += difficultProfitArray[index][2];
            } else {
                index = (index*-1) - 1;
                if (index - 1 >= 0) {
                    ans += difficultProfitArray[index-1][2];
                }
            }
        }
        
        return ans;
    }
}