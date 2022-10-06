class Solution {
    int MODULU = 1000000007;
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        
        int high = inventory.length - 1;
        
        int sameSize = inventory[high--];
        int sameSizeCount = 1;
        
        long ans = 0;
        while (high >= 0) {
            if (sameSize == inventory[high]) {
                sameSizeCount++;
            } else {
                int diff = sameSize - inventory[high];
                int numberOfOrdersCanFulFill = sameSizeCount * diff;
                
                if (numberOfOrdersCanFulFill > orders) {
                    break;
                } else {
                    orders -= numberOfOrdersCanFulFill;
                    
                    long diff1 = (sumOfN(sameSize) - sumOfN(inventory[high])) % MODULU;
                    long mult = (sameSizeCount*diff1)  % MODULU;
                    ans = (ans + mult) % MODULU;
                    
                    sameSize = inventory[high];
                    sameSizeCount++;
                }
            }
            
            high--;
            
        }
        
        // System.out.println(orders + ":" + sameSize);
        
        long fromAll = orders / sameSizeCount;
        long rem = orders % sameSizeCount;
        
        
        
        if (fromAll == 0) {
            long temp1 = (rem * sameSize) % MODULU;
            ans = (ans + temp1) % MODULU;
        } else {
            long diff = (sumOfN(sameSize) - sumOfN(sameSize - fromAll)) % MODULU; 
            long mult = (sameSizeCount*diff) % MODULU;
            ans = (ans + mult) % MODULU;  
            
            
            long temp1 = (1l * rem * (sameSize - fromAll)) % MODULU;
            ans = (ans + temp1) % MODULU;
        }
        return (int) (ans % MODULU);
    }
    
    private long sumOfN(long n) {
        return 1l * n * (n+1) / 2l;
    }
}