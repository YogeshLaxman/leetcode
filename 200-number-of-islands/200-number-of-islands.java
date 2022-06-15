class Solution {
    int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, numberOfIslands = 0;
        
        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    numberOfIslands++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        
        return numberOfIslands;
    }
    
    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        int m = grid.length, n = grid[0].length;
        
        for (int dir[]: directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if (x >= 0 && x < m && y >=0 && y < n && grid[x][y] == '1' && !visited[x][y]) {
                dfs(grid, x, y, visited);
            }
        }
    } 
}