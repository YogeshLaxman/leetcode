public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // 00000... 011
        // 11111....100
        // 11111....101
        
        int[] bits = new int[32];
       
        boolean isNegative = false;
        if (n < 0) {
            n = n * -1;
            isNegative = true;
        }
        
        int index = 0;
        while (n != 0) {
            bits[index++] = n % 2;
            n = n / 2;
        }
        
        if (isNegative) {
            for (int i=0; i<32; i++) {
                if (bits[i] == 0) {
                    bits[i] = 1;
                } else {
                    bits[i] = 0;
                }
            } 
            
            
            for (int i=0; i<32; i++) {
                if (bits[i] == 1) {
                    bits[i] = 0;
                } else {
                    bits[i] = 1;
                    break;
                }
            }
        }
        
        int ans = 0;
        for (int i=0; i<32; i++) {
            if (bits[i] == 1) {
                ans++;
            }
        }
        
        return ans;
    }
}