class Solution {
    private int binarySerach(int[] potions, int value) {
        // System.out.println("Serach: " + value);
        int low = 0, high = potions.length - 1;
        
        int ans = potions.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (potions[mid] >= value) {
                // ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        
        // System.out.println(Arrays.toString(potions));
        int n = spells.length;
        
        int[] ans = new int[n];
        for (int i=0; i<n; i++) {
            long times = (long) Math.ceil(1.0 * success / spells[i]);

            if (times > Integer.MAX_VALUE) {
                ans[i] = 0;
            } else {
                int search = (int) times;
                int index = binarySerach(potions, search);
                // System.out.println(index);
                ans[i] = potions.length - index;
            }
        }
        
        return ans;
    }
}