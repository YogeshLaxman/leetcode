class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n= grid[0].length;
        int[][][] memo = new int[m][n][201];
        
        return hasValidPath(grid, 0, 0, 0, memo);
    }
    
    private boolean hasValidPath(char[][] grid, int i, int j, int currentOpen, int[][][] memo) {
        //System.out.println(i + ":" + j);
        int m = grid.length;
        int n= grid[0].length;
        
        if (memo[i][j][currentOpen] != 0) {
            // System.out.println("here");
            return memo[i][j][currentOpen] == 1;
        }
        
        int intial = currentOpen;
        if (grid[i][j] == '(') {
            currentOpen++;
        } else if (currentOpen <= 0) {
            return false;
        } else {
            currentOpen--;
        }
        
        if (i == m-1 && j == n-1 && currentOpen == 0) {
            return true;
        } 
        
        boolean ans = false;
        if (i+1 < m) {
            ans = ans || hasValidPath(grid, i+1, j, currentOpen, memo);   
        }
        if (j+1 < n) {
            ans = ans || hasValidPath(grid, i, j+1, currentOpen, memo);    
        }
        
        memo[i][j][intial] = ans ? 1 : 2;
        
        return ans;
    }
}