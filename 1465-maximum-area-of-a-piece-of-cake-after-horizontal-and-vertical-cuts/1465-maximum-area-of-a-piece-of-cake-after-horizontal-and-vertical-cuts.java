class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long maxH = 0;
        int prev = 0;
        for (int hCut: horizontalCuts) {
            maxH = Math.max(hCut - prev, maxH);
            prev = hCut;
        }
        maxH = Math.max(h - prev, maxH);
        
        long maxW = 0;
        prev = 0;
        for (int vCut: verticalCuts) {
            maxW = Math.max(vCut - prev, maxW);
            prev = vCut;
        }
        maxW = Math.max(w - prev, maxW);
        
        return (int) ((maxW * maxH) % 1000000007);
    }
}