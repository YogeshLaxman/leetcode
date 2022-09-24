class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long sum = 1l;
        int max = 0;
        
        for (int d: damage) {
            sum += d;
            max = Math.max(d, max);
        }
        
        sum -= Math.min(armor, max);
        
        return sum;
    }
}