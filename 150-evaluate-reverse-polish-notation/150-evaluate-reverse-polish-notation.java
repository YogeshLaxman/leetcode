class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String s: tokens) {
            if (isOperator(s)) {
                int second = stack.pop();
                int first = stack.pop();
                
                int result = 0;
                if (isPlus(s)) {
                    result = first + second;
                }
                
                if (isMinus(s)) {
                    result = first - second;
                }
                
                if (isMult(s)) {
                    result = first * second;
                }
                
                if (isDiv(s)) {
                    result = first / second;
                }
                
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        
        return stack.pop();
    }
    
    private boolean isOperator(String s) {
        return isPlus(s) || isMinus(s) || isMult(s) || isDiv(s);
    }
    
    private boolean isPlus(String s) {
        return "+".equals(s);
    }
    
    private boolean isMinus(String s) {
        return "-".equals(s);
    }
    
    private boolean isMult(String s) {
        return "*".equals(s);
    }
    
    private boolean isDiv(String s) {
        return "/".equals(s);
    }
}