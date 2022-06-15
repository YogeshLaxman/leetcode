class UnionFind {
    int m, n;
    int[] parent;
    
    UnionFind(int m, int n) {
        this.m = m; this.n = n;
        parent = new int[m*n];
        
        Arrays.fill(parent, -1);
    }
    
    int findIndex(int i, int j) {
        if (i == 0) return j;
        return (i * n) + j;
    }
    
    int find(int i, int j) {
        int index = findIndex(i, j);
        // System.out.println(i + ":" + j + ":" + index);
        return find(index);
    }
    
    int find(int index) {
        // System.out.println(index);
        if (parent[index] < 0) return index;
        parent[index] = find(parent[index]);
        return parent[index];
    }
    
    void exclude(int i, int j) {
        int index = findIndex(i, j);
        
        // positive impossible value
        parent[index] = m * n;
    }
    
    void union (int x, int y) {
        int rankX = Math.abs(parent[x]);
        int rankY = Math.abs(parent[y]);
        
        if (rankX > rankY) {
            parent[y] = x;
            parent[x] = -1 * (rankX + rankY);
        } else {
            parent[x] = y;
            parent[y] = -1 * (rankX + rankY);
        }
    }
    
    int numberOfDisticSets() {
        int count = 0;
        for (int v: parent) {
            if (v < 0) count++;
        }
        return count;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{1,0}, {0,1}, {0,-1}, {-1,0}};
        
        UnionFind uf = new UnionFind(m, n);
        
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '0') {
                    uf.exclude(i, j);
                } else {
                    for (int[] dir: directions) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        
                        if (x >=0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                            int parent1 = uf.find(x, y);
                            int parent2 = uf.find(i, j);
                            if (parent1 != parent2) {
                                uf.union(parent1, parent2);
                            }
                        }
                    }
                }
            }
        }
        
        return uf.numberOfDisticSets();
    }
}