class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] ans = new int[m][n];
        
        int[][] directions = {{0,1}, {1,0}, {0, -1}, {-1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                ans[i][j] = board[i][j];
            }
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int count = 0;
                for (int[] dir: directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && y >= 0 && x < m && y < n) {
                        if (ans[x][y] == 1) {
                            count++;
                        }
                    }
                }
                // System.out.println(count);
                if (ans[i][j] == 1) {
                    board[i][j] = 0;
                    if (count == 2 || count == 3) {
                        board[i][j] = 1;
                    }
                } else {
                    if (count == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
}