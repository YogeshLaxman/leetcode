class Solution {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        
        int num = 0;
        boolean numFound = false;
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                numFound = true;
                num = (num * 10) + (c - '0');
            } else {
                if (numFound) {
                    stack.push(String.valueOf(num));
                    num = 0;
                    numFound = false;
                }
                if (c == ')') {
                    LinkedList<String> list = new LinkedList<>();
                    while (!stack.peek().equals("(")) {
                        list.addFirst(stack.pop());
                    }
                    stack.pop();
                    int answer = evaluate(list);
                    stack.push(String.valueOf(answer));
                } else {
                    stack.push(String.valueOf(c));
                }
            }
        }
        
        if (numFound) {
            stack.push(String.valueOf(num));
        }
        if (stack.size() == 1) {
            return Integer.parseInt(stack.pop());
        }
        LinkedList<String> list = new LinkedList<>();
        // System.out.println(stack);
        while (!stack.isEmpty()) {
            list.addFirst(stack.pop());
        }
        return evaluate(list);
    }
    
    private int evaluate(LinkedList<String> list) {
        
        LinkedList<String> newList = new LinkedList<>();
        
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).equals("*")) {
                int a = Integer.parseInt(newList.removeLast());
                int b = Integer.parseInt(list.get(i+1));
                i++;
                newList.addLast(String.valueOf(a*b));
            } else if (list.get(i).equals("/")) {
                int a = Integer.parseInt(newList.removeLast());
                int b = Integer.parseInt(list.get(i+1));
                i++;
                newList.addLast(String.valueOf(a/b));
            } else {
                newList.addLast(list.get(i));
            }
        }
        list = newList;
        newList = new LinkedList<>();
        
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).equals("+")) {
                int a = Integer.parseInt(newList.removeLast());
                int b = Integer.parseInt(list.get(i+1));
                i++;
                newList.addLast(String.valueOf(a+b));
            } else if (list.get(i).equals("-")) {
                int a = Integer.parseInt(newList.removeLast());
                int b = Integer.parseInt(list.get(i+1));
                i++;
                newList.addLast(String.valueOf(a-b));
            } else {
                newList.addLast(list.get(i));
            }
        }
        // System.out.println(newList);
        return Integer.parseInt(newList.get(0));
    }
}