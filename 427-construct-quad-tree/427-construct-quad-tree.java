/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    
    public Node construct(int[][] grid) {
        int n = grid.length;
        return construct(grid, 0, 0, n-1, n-1);
    }
    
    public Node construct(int[][] grid, int a, int b, int x, int y) {
        
        int total = 0, numOfOnes = 0;
        for (int i=a; i<=x; i++) {
            for (int j=b; j<=y; j++) {
                total++;
                if (grid[i][j] == 1) {
                    numOfOnes++;
                }
            }
        }
        
        Node node = new Node();
        if (total == numOfOnes) {
            node.isLeaf = true;
            node.val = true;
        } else if (total == (total - numOfOnes)) {
            node.isLeaf = true;
            node.val = false;
        } else {
            int midX = (a + x) / 2;
            int midY = (b + y) / 2;
            
            node.topLeft = construct(grid, a, b, midX, midY);
            node.topRight = construct(grid, a, midY+1, midX, y);
            node.bottomLeft = construct(grid, midX+1, b, x, midY);
            node.bottomRight = construct(grid, midX+1, midY+1, x, y);
        }
        
        return node;
    }
}