class UnionFind {
    int[] parent;
    
    UnionFind(int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);
    }
    
    int find(int x) {
        if (parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }
    
    void union(int x, int y) {
        if (Math.abs(parent[x]) > Math.abs(parent[y])) {
            parent[x] += parent[y];
            parent[y] = x;
        } else {
            parent[y] += parent[x];
            parent[x] = y;
        }
    }
    
    int getNumberOfDistincSets() {
        int count = 0;
        for (int p: parent) {
            if (p < 0) count++;
        }
        
        return count;
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) return false;
        
        UnionFind uf = new UnionFind(n);
        for (int[] edge: edges) {
            int u = uf.find(edge[0]);
            int v = uf.find(edge[1]);
            
            if (u == v) return false;
            uf.union(u, v);
        }
        
        return uf.getNumberOfDistincSets() == 1;
    }
}