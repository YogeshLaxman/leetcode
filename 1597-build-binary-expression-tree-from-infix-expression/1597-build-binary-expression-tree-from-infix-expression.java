/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Node solve(LinkedList<Node> list) {
        LinkedList<Node> newList = new LinkedList<>();
        
        int index = 0;
        while (index <list.size()) {
            Node node = list.get(index);
            if (node.val == ')') {
                LinkedList<Node> subList = new LinkedList();
                while (newList.getLast().val != '(') {
                    subList.addFirst(newList.removeLast());
                }
                
                newList.removeLast();
                newList.add(solve(subList));
                
            } else {
                newList.add(node);    
            }
            index++;
        }
        
        list = newList;
        LinkedList<Node> listAfterMultDivide = new LinkedList<>();
        index = 0;
        while (index < list.size()) {
            Node node = list.get(index);
            if (node.val == '/' || node.val == '*') {
                if (node.left != null && node.right != null) {
                    listAfterMultDivide.add(node); 
                    index++;
                    continue;
                }
                Node operand1 = listAfterMultDivide.removeLast();
                Node operand2 = list.get(++index);
                node.left = operand1;
                node.right = operand2;
                
            }
            listAfterMultDivide.add(node);    
            index++;
        }
        
        
        LinkedList<Node> finalList = new LinkedList<>();
        index = 0;
        while (index < listAfterMultDivide.size()) {
            Node node = listAfterMultDivide.get(index);
            if (node.val == '-' || node.val == '+') {
                if (node.left != null && node.right != null) {
                    finalList.add(node); 
                    index++;
                    continue;
                }
                Node operand1 = finalList.removeLast();
                Node operand2 = listAfterMultDivide.get(++index);
                node.left = operand1;
                node.right = operand2;
            }
            
            finalList.add(node);    
            index++;
        }

        return finalList.get(0);
    }
    
    public Node expTree(String s) {
        LinkedList<Node> list = new LinkedList<>();
        
        for (char c: s.toCharArray()) {
            list.add(new Node(c));    
        }
        
        return solve(list);
    }
}