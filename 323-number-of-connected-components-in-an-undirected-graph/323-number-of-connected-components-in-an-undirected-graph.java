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
        if (parent[x] < parent[y]) {
            parent[x] += parent[y];
            parent[y] = x;
        } else {
            parent[y] += parent[x];
            parent[x] = y;
        }
    }
    
    int getNumberOfDisconnectedSets() {
        int count = 0;
        for (int p: parent) {
            if (p < 0) {
                count++;
            }
        }
        
        return count;
    }
}
class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        
        for (int[] edge: edges) {
            int x = uf.find(edge[0]);    
            int y = uf.find(edge[1]);    
            
            if (x != y) {
                uf.union(x, y);
            }
        }
        
        return uf.getNumberOfDisconnectedSets();
    }
}