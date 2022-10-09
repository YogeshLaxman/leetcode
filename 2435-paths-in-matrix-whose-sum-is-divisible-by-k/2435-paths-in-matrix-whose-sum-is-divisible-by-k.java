class Solution {
    int MODULU = 1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        
        int[][][] memo = new int[m][n][k];
        int startNum = grid[0][0];
        memo[0][0][startNum % k] = 1;
        
        boolean[][] addedToQueue = new boolean[m][n];
        addedToQueue[0][0] = true;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        
        int[][] directions = {{0,1}, {1,0}};
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            
            int r = cell[0];
            int c = cell[1];
            
            for (int[] direction: directions) {
                int x = r + direction[0];
                int y = c + direction[1];
                
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    for (int i=0; i<k; i++) {
                        int newR = (i + grid[x][y]) % k;
                        memo[x][y][newR] = (int) ((0l + memo[x][y][newR] + memo[r][c][i]) % MODULU);
                    }
                    
                    if (!addedToQueue[x][y]) {
                        addedToQueue[x][y] = true;
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
        
        return memo[m-1][n-1][0];
    }
}