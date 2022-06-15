class Coordinate {
    int r;
    int c;
    
    Coordinate(int r, int c) {
        this.r = r;
        this.c = c;
    } 
}

class Solution {
    int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, numberOfIslands = 0;
        
        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    numberOfIslands++;
                    bfs(grid, i, j, visited);
                }
            }
        }
        
        return numberOfIslands;
    }
    
    private void bfs(char[][] grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        int m = grid.length, n = grid[0].length;
        
        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        queue.add(new Coordinate(i, j));
        
        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            
            for (int dir[]: directions) {
                int x = coordinate.r + dir[0];
                int y = coordinate.c + dir[1];

                if (x >= 0 && x < m && y >=0 && y < n && grid[x][y] == '1' && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new Coordinate(x, y));
                }
        }
        }
        
    } 
}