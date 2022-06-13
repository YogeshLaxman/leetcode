class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int[] ans = new int[k];
        
        return distributeCookies(cookies, 0, ans);
    }
    
    private int distributeCookies(int[] cookies, int index, int[] ans) {
        if (index == cookies.length) {
            // System.out.println(Arrays.toString(ans));
            int max = 0;
            for (int i=0; i<ans.length; i++) {
                max = Math.max(max, ans[i]);
            }
            return max;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i=0; i<ans.length; i++) {
            ans[i] = ans[i] + cookies[index];
            min = Math.min(min, distributeCookies(cookies, index+1, ans));
            ans[i] = ans[i] - cookies[index];
        }
        
        return min;
    }
}