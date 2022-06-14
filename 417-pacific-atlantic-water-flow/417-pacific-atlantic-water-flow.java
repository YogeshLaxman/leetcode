class Coordinate {
    int r, c;
    
    Coordinate(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n]; 
        Queue<Coordinate> queue = new LinkedList<>();
        
        // Seed value
        queue.add(new Coordinate(0,0));
        pacific[0][0] = true;    
        for (int i=1; i<m; i++) {
            queue.add(new Coordinate(i,0));
            pacific[i][0] = true;    
        }
        for (int j=1; j<n; j++) {
            queue.add(new Coordinate(0,j));
            pacific[0][j] = true;    
        }
        
        
        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            for (int[] dir: directions) {
                int x = dir[0] + coordinate.r;
                int y = dir[1] + coordinate.c;
                
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (!pacific[x][y] && heights[x][y] >= heights[coordinate.r][coordinate.c]) {
                        queue.add(new Coordinate(x,y));
                        pacific[x][y] = true;
                    }
                }
            }
        }
        
        boolean[][] atlantic = new boolean[m][n]; 
        
        // Seed value
        queue.add(new Coordinate(m-1,n-1));
        atlantic[m-1][n-1] = true;    
        for (int i=0; i<m-1; i++) {
            queue.add(new Coordinate(i,n-1));
            atlantic[i][n-1] = true;    
        }
        for (int j=0; j<n-1; j++) {
            queue.add(new Coordinate(m-1,j));
            atlantic[m-1][j] = true;    
        }
        
        
        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            for (int[] dir: directions) {
                int x = dir[0] + coordinate.r;
                int y = dir[1] + coordinate.c;
                
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (!atlantic[x][y] && heights[x][y] >= heights[coordinate.r][coordinate.c]) {
                        queue.add(new Coordinate(x,y));
                        atlantic[x][y] = true;
                    }
                }
            }
        }
        
        List<List<Integer>> answer = new ArrayList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    answer.add(Arrays.asList(i, j));
                }
            }
        }
        
        return answer;
    }
}