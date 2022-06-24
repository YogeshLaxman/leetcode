class MedianFinder {
    
    PriorityQueue<Integer> leftPQ;
    PriorityQueue<Integer> rightPQ;
    
    public MedianFinder() {
        leftPQ = new PriorityQueue<>((a,b) -> {
            if (b > a) return 1;
            if (a > b) return -1;
            return 0;
        });
        rightPQ = new PriorityQueue<>((a,b) ->{
            if (b > a) return -1;
            if (a > b) return 1;
            return 0;
        });
        
        // dummy values
        leftPQ.add(Integer.MIN_VALUE);
        rightPQ.add(Integer.MAX_VALUE);
    }
    
    public void addNum(int num) {
        leftPQ.add(num);
        // System.out.println(leftPQ.peek());
        if (leftPQ.peek() > rightPQ.peek()) {
            int temp = rightPQ.poll();
            rightPQ.add(leftPQ.poll());
            leftPQ.add(temp);
        }
        
        if (leftPQ.size() - rightPQ.size() == 2) {
            rightPQ.add(leftPQ.poll());
        } 
        
        // System.out.println(leftPQ.peek());
        // System.out.println(rightPQ.peek());
    }
    
    public double findMedian() {
        if (leftPQ.size() == rightPQ.size()) {
            return (leftPQ.peek() + rightPQ.peek()) / 2.0;
        } 
        return leftPQ.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */