class Cell {
    int row;
    int col;
    Set<String> seen;
    int k;
    int steps;
    
    Cell(int row, int col, int k, int s, Set<String> seen) {
        this.row = row;
        this.col = col;
        
        this.k = k;
        this.steps = s;
        
        this.seen = seen;
    }
}

class Solution {
    public int shortestPath(int[][] grid, int k) {
        
        int m = grid.length, n = grid[0].length;
        Set<String> visited = new HashSet<>();
        Queue<Cell> queue = new LinkedList<>();
        
        Set<String> seen = new HashSet<>();
        visited.add("0#0#" + k);
        seen.add("0#0");
        
        queue.add(new Cell(0, 0, k, 0, seen));
        
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        while(!queue.isEmpty()) {
            Cell cell = queue.poll();
            
            if (cell.row == m-1 && cell.col == n-1) {
                return cell.steps;
            }
            
            for (int[] dir: directions) {
                int x = cell.row + dir[0];
                int y = cell.col + dir[1];
                
                String key = x + "#" + y;
                if (x >= 0 && x < m && y >= 0 && y < n && !cell.seen.contains(key)) {
                    String visitedKey = x + "#" + y + "#" + cell.k;
                    if (visited.contains(visitedKey)) {
                        continue;
                    }
                    
                    visited.add(visitedKey);
                    Set<String> newSeen = new HashSet<>(cell.seen);
                    newSeen.add(key);
                    
                    int newK = cell.k;
                    if (grid[x][y] == 1) {
                        if (cell.k > 0) {
                            newK--;
                        } else {
                            continue;
                        }
                    }
                    
                    if (x == m-1 && y == n-1) {
                        return cell.steps + 1;
                    }
                    queue.add(new Cell(x, y, newK, cell.steps+1, newSeen));
                }
            }
        }
        
        return -1;
        
    }
    
}