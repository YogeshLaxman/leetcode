/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    Node left;
    Node right;
    
    public abstract int evaluate();
    // define your fields here
};

class IntegerNode extends Node {
    int value;
    
    IntegerNode(int v) {
        this.value = v;
    }
    
    public int evaluate() {
        return this.value;
    }
}

abstract class OperatorNode extends Node {
    int value;
    
    OperatorNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
}

class PlusNode extends OperatorNode {
    PlusNode(Node left, Node right) {
        super(left, right);
    }
    
    public int evaluate() {
        return left.evaluate() + right.evaluate();
    }
}

class MinusNode extends OperatorNode {
    MinusNode(Node left, Node right) {
        super(left, right);
    }
    
    public int evaluate() {
        return left.evaluate() - right.evaluate();
    }
}

class MultiplyNode extends OperatorNode {
    MultiplyNode(Node left, Node right) {
        super(left, right);
    }
    
    public int evaluate() {
        return left.evaluate() * right.evaluate();
    }
}

class DivideNode extends OperatorNode {
    DivideNode(Node left, Node right) {
        super(left, right);
    }
    
    public int evaluate() {
        return left.evaluate() / right.evaluate();
    }
}


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<Node> stack = new Stack<>();
        
        for (String s: postfix) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                Node right = stack.pop();
                Node left = stack.pop();
                
                if (s.equals("+")) {
                    stack.push(new PlusNode(left, right));
                }
                
                if (s.equals("-")) {
                    stack.push(new MinusNode(left, right));
                }
                
                if (s.equals("*")) {
                    stack.push(new MultiplyNode(left, right));
                }
                
                if (s.equals("/")) {
                    stack.push(new DivideNode(left, right));
                }
            } else {
                stack.push(new IntegerNode(Integer.parseInt(s)));
            }
        }
        
        return stack.pop();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */