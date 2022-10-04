class Solution {
    public int kthFactor(int n, int k) {
        int factorNum = 0;
        for (int i=1; i<=n; i++) {
            if (n % i == 0) {
                factorNum++;
                if (factorNum == k) {
                    return i;
                }
            }
        }
        
        return -1;
    }
}