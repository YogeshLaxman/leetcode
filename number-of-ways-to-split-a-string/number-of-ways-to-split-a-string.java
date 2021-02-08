class Solution {
    int MODULU = 1000000007;
    public int numWays(String s) {
        int n = s.length();
        boolean[] sArray = new boolean[n];
        
        int sum = 0;
        for(int i=0; i<n; i++) {
            if (s.charAt(i) == '1') {
                sArray[i] = true; 
                sum++;
            }
        }
        
        if (sum == 0) {
            return (int) ((1l*(n-2)*(n-1)/2) % MODULU);
        }
        
        if (sum % 3 != 0) {
            return 0;
        }
        int x = sum/3;
        
        int low = 0;
        sum = 0;
        while (sum != x) {
            if (sArray[low++]) {
                sum++;
            }
        }
        
        sum = 0;
        int high = n-1;
        while (sum != x) {
            if (sArray[high--]) {
                sum++;
            }
        }
        
        int lCount = 1;
        while(!sArray[low++]) {
            lCount++;
        }
        
        int rCount = 1;
        int count =lCount; 
        while(!sArray[high--]) {
            rCount++;
            count = (count + lCount) % MODULU;
        }
        return count;
    }
}