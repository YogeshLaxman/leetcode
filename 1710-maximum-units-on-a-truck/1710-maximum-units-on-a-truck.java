class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        
        int ans = 0;
        for (int[] boxType: boxTypes) {
            int num = boxType[0];
            int units = boxType[1];
            
            if (num < truckSize) {
                ans += (num * units);
                truckSize -= num;
            } else {
                ans += (truckSize * units);
                break;
            }
        }
        
        return ans;
    }
}