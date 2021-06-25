class Solution {
    int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        
        int count = 2;
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                if (grid1[i][j] == 1) {
                    dfs(grid1, i, j, count);
                    count++;
                }
            }
        }
        
        int result = 0;
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (isSubgrid(grid1, grid2, i, j, grid1[i][j])) {
                        result++;
                    }
                }
            }
        }
        
        return result;
        
    }
    
    private void dfs(int[][] grid1, int i, int j, int num) {
        grid1[i][j] = num;
        
        for (int[] dir: direction) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            
            if (x >=0 && y >=0 && x < grid1.length && y < grid1[x].length && grid1[x][y] == 1) {
                dfs(grid1, x, y, num);
            }
        }
    }
    
    private boolean isSubgrid(int[][] grid1, int[][] grid2, int i, int j, int num) {
        boolean ans = true;
        
        if (num == 0 || grid1[i][j] != num) ans = false;
        grid2[i][j] = 2;
        
        for (int[] dir: direction) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            
            if (x >=0 && y >=0 && x < grid2.length && y < grid2[x].length && grid2[x][y] == 1) {
                ans = ans & isSubgrid(grid1, grid2, x, y, num);
            }
        }
        
        return ans;
    }
}