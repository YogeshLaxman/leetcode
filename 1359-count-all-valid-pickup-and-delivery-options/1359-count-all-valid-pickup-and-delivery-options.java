class Solution {
    int MODULU = 1000000007;
    public int countOrders(int n) {
        int[][] memo = new int[n+1][n+1];
        for (int[] item: memo) {
            Arrays.fill(item, -1);
        }
        return countOrders(0, 0, n, memo);
    }
    
    private int countOrders(int pickUpDone, int deliveryDone, int n, int[][] memo) {
        if (pickUpDone==deliveryDone && n == pickUpDone) return 1;
        
        int remPickup = n - pickUpDone;
        int remDelivery = pickUpDone - deliveryDone;
        
        if (memo[pickUpDone][deliveryDone] != -1) {
            return memo[pickUpDone][deliveryDone];
        }
        int ans = 0;
        if (remPickup != 0) {
            ans = (int) (ans + (1l * remPickup * countOrders(pickUpDone+1, deliveryDone, n, memo)) % MODULU) % MODULU;
        }
        
        if (remDelivery != 0) {
            ans = (int) (ans + (1l * remDelivery * countOrders(pickUpDone, deliveryDone+1, n, memo)) % MODULU) % MODULU;
        }
        
        
        return memo[pickUpDone][deliveryDone] = ans;
    }
}