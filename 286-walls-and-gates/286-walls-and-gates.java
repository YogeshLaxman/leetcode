class Cell {
    int r;
    int c;
    int value;
    
    Cell(int r, int c, int v) {
        this.r = r;
        this.c = c;
        value = v;
    }
}
class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        
        Queue<Cell> queue = new LinkedList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new Cell(i, j, 0));
                }
            }
        }
        
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            
            int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
            
            for (int[] dir: directions) {
                int r = cell.r + dir[0];
                int c = cell.c + dir[1];
                int value = cell.value + 1;
                
                if (r >= 0 && r < m && c >= 0 && c < n && rooms[r][c] == Integer.MAX_VALUE) {
                    rooms[r][c] = value;
                    queue.add(new Cell(r, c, value));
                }
            }
        }
        
    }
}