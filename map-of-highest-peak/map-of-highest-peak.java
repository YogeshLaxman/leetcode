class Cell {
    int r;
    int c;
    int v;
    Cell(int r, int c, int v) {
        this.r = r; this.c = c; this.v = v;
    }
}
class Solution {
    
    int[][] direction = {{0,1}, {0,-1}, {1, 0}, {-1, 0}};
    
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] answer = new int[m][n];
        
        Queue<Cell> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (isWater[i][j] == 1) {
                    q.add(new Cell(i,j, 0));
                    visited[i][j] = true;
                }
            }
        }
        
        while (!q.isEmpty()) {
            int qs=q.size();
            for (int i=0; i<qs; i++) {
                Cell cell  = q.poll();
                int r = cell.r;
                int c = cell.c;
                int v = cell.v;
                
                answer[r][c] = v;
                for (int[] dir: direction) {
                    int x = r + dir[0];
                    int y = c + dir[1];

                    if (x >=0 && y >= 0 && x < m && y < n && !visited[x][y]) {
                        visited[x][y] = true;
                        q.add(new Cell(x, y, v+1));
                    }
                }
            }
            
        }
        return answer;
    }
}