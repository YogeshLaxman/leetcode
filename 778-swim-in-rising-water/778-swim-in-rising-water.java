class Cell {
    int r;
    int c;
    int value;
    
    Cell(int r, int c, int v) {
        this.r = r;
        this.c = c;
        this.value = v;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b) -> a.value - b.value);
        pq.add(new Cell(0, 0, grid[0][0]));
        visited[0][0] = true;
        
        int max = -1;
        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            
            max = Math.max(max, cell.value);
            
            // System.out.println(cell.value);
            
            if (cell.r == m-1 && cell.c == n-1) {
                return max;
            }
            
            for (int[] dir: directions) {
                int x = cell.r + dir[0];
                int y = cell.c + dir[1];
                
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    pq.add(new Cell(x, y, grid[x][y]));
                }
            }
        }
        
        return -1;
    }
}