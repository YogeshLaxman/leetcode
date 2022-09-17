class Solution {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        Set<String> distinctIslands = new HashSet<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 2;
                    String s = expand(grid, i, j);
                    // System.out.println("s" + s);
                    distinctIslands.add(s);
                }
            }
        }
        
        // System.out.println(Arrays.deepToString(grid));
        return distinctIslands.size();
    }
    
    private static String expand(int[][] grid, int i, int j) {
        String s = "";
        int m = grid.length, n = grid[0].length;
        
        int[][] directions = {{1,0,1}, {0,1,2}, {-1,0,3}, {0,-1,4}};
        
        for (int[] dir: directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                grid[x][y] = 2;
                s = s + "(" + dir[2] + expand(grid, x, y) + ")";
            }
        }
        
        return s;
    }
}