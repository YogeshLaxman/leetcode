class Node {
    int value;
    int freq;
    int timeStamp;
    
    Node(int v, int f, int t) {
        value = v;
        freq = f;
        timeStamp = t;
    }
}

class FreqStack {
    
    PriorityQueue<Node> stack;
    Map<Integer, Integer> freqMap;
    int timestamp;
    public FreqStack() {
        stack = new PriorityQueue<>((a, b) -> {
            if (a.freq == b.freq) return b.timeStamp - a.timeStamp;
            return b.freq - a.freq;
        });
        freqMap = new HashMap<>();
        timestamp = 0;
    }
    
    public void push(int x) {
        int cur = freqMap.getOrDefault(x, 0);
        freqMap.put(x, cur+1);
        stack.add(new Node(x, cur+1, timestamp));
        timestamp++;
    }
    
    public int pop() {
        Node node = stack.poll();
        freqMap.put(node.value, node.freq - 1);
        return node.value;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */