class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        int[][] bottom = new int[m][n];
        int[][] top = new int[m][n];
        
        for (int i=0; i<m; i++) {
            int previous = 0;
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 'W') {
                    previous = 0;
                } else if (grid[i][j] == 'E') {
                    previous++;
                    left[i][j] = previous;
                } else {
                    left[i][j] = previous;
                }
            }
        }
        
        for (int i=0; i < m; i++) {
            int previous = 0;
            for (int j=n-1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    previous = 0;
                } else if (grid[i][j] == 'E') {
                    previous++;
                    right[i][j] = previous;
                } else {
                    right[i][j] = previous;
                }
            }
        }
        
        for (int j=0; j<n; j++) {
            int previous = 0;
            for (int i=0; i<m; i++) {
                if (grid[i][j] == 'W') {
                    previous = 0;
                } else if (grid[i][j] == 'E') {
                    previous++;
                    top[i][j] = previous;
                } else {
                    top[i][j] = previous;
                }
            }
        }
        
        for (int j=0; j<n; j++) {
            int previous = 0;
            for (int i=m-1; i>=0; i--) {
                if (grid[i][j] == 'W') {
                    previous = 0;
                } else if (grid[i][j] == 'E') {
                    previous++;
                    bottom[i][j] = previous;
                } else {
                    bottom[i][j] = previous;
                }
            }
        }
        
        int ans = 0;
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '0') {
                    ans = Math.max(ans, left[i][j] + right[i][j] + bottom[i][j] + top[i][j]);
                }
            }
        }
        
        return ans;
        
    }
}