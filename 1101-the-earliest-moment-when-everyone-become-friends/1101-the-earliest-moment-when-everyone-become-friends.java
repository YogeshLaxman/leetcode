class UnionFind  {
    int[] parent;
    
    UnionFind(int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);
    }
    
    int find(int x) {
        // System.out.println(x);
        if (parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }
    
    boolean union(int x, int y) {
        if (parent[x] < parent[y]) {
            parent[x] += parent[y];
            parent[y] = x;
            return Math.abs(parent[x]) == parent.length;
        } else {
            parent[y] += parent[x];
            parent[x] = y;
            return Math.abs(parent[y]) == parent.length;
        }
    }
}

class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a,b) -> a[0] - b[0]);
        
        UnionFind uf = new UnionFind(n);
        
        int totallinked = 0;
        for(int[] log: logs) {
            int u = uf.find(log[1]);
            int v = uf.find(log[2]);
            
            if (u != v) {
                if (uf.union(u, v)) {
                    return log[0];
                }
                
            }
        }
        
        return -1;
    }
}