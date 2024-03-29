class Node {
    boolean fullyPainted;
    Node leftNode;
    Node rightNode;
    
    int left;
    int mid;
    int right;
    
    int count;
    
    Node(int left, int right) {
        this.left = left;
        this.mid = (left + right) / 2;
        this.right = right;
    }
    
    Node getLeftNode() {
        if (leftNode == null) {
            leftNode = new Node(left, mid);
        }
        
        return leftNode;
    }
    
    Node getRightNode() {
        if (rightNode == null) {
            rightNode = new Node(mid, right);
        }
        
        return rightNode;
    }
}

class SegmentTree {
    Node root;
    
    SegmentTree() {
        root = new Node(0, 50001);
    }
    
    int addRange(int start, int end) {
        return addRange(root, start, end);
        
    }
    
    int addRange(Node node, int start, int end) {
        
        if (node.fullyPainted || end-start < 1) {
            return 0;
        }
        
        if (node.left == start && node.right == end) {
            int rem = (end - start) - node.count;
            node.count = end - start;
            node.fullyPainted = true;    
        }
        
        if (node.left+1 == node.right) {
            
            node.fullyPainted = true;
            node.count = 1;
            return 1;
        }
        
        int ans = 0;
        
        if(end <= node.mid) {
            ans = addRange(node.getLeftNode(), start, end);
        } else if (start >= node.mid) {
            ans = addRange(node.getRightNode(), start, end);
        } else {
            ans = addRange(node.getLeftNode(), start, node.mid) + addRange(node.getRightNode(), node.mid, end);
        }
        
        if (node.leftNode != null && node.leftNode.fullyPainted 
            && node.rightNode != null && node.rightNode.fullyPainted) {
            node.fullyPainted = true;
        }
        
        int count = 0;
        if (node.leftNode != null) {
            count += node.leftNode.count;
        }
        
        if (node.rightNode != null) {
            count += node.rightNode.count;
        }
        
        node.count = count;
        
        return ans;
    }
}


class Solution {
    public int[] amountPainted(int[][] paint) {
        int n = paint.length;
        boolean[] painted = new boolean[50001];
        
        int[] ans = new int[n];
        
        SegmentTree tree = new SegmentTree();
        for (int i=0; i<paint.length; i++) {
            ans[i] = tree.addRange(paint[i][0], paint[i][1]);
            // System.out.println("new iteration");
        }
        
        return ans;
    }
}