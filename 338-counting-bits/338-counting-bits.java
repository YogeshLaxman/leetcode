class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        
        ans[0] = 0;
        int index = 1, copyIndex = 0, power = 1;
        while (index <= n) {
            for (; index < Math.pow(2, power) && index <= n; index++) {
                ans[index] = ans[copyIndex++] + 1;
            }
            copyIndex = 0; power ++;
        }
        
        return ans;
    }
    
    /*
    0 -> 0 - 0
    1 -> 1 - 1
    2 -> 10 - 1
    3 -> 11 - 2
    4 -> 100 - 1
    5 -> 101 - 2
    6 -> 110 - 2
    7 -> 111 - 3
    8 -> 1000 - 1
    9 -> 10001 - 2
    
    */
}