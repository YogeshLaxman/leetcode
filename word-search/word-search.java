class Solution {
    int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public boolean exist(char[][] board, String word) {
        int numRows = board.length;
        int numCols = board[0].length;
        
        boolean[][] visited = new boolean[numRows][numCols];
        
        for (int i=0; i < numRows; i++) {
            for (int j=0; j < numCols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (exist(board, i, j, word, 1, visited)) return true;            
                    visited[i][j] = false;
                }
            }
        }
        
        return false;
    }
    
    private boolean exist(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (index == word.length()) return true;
        
        for (int[] dir: direction) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            
            if (x >= 0 && y >= 0 && x < board.length && y < board[x].length && !visited[x][y] && word.charAt(index) == board[x][y]) {
                visited[x][y] = true;
                if (exist(board, x, y, word, index+1, visited)) return true;             
                visited[x][y] = false;
            }
        }
        
        return false;
    }
}