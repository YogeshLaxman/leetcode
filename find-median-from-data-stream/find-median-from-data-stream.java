class MedianFinder {
    PriorityQueue<Integer> leftHeap;
    PriorityQueue<Integer> rightHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        leftHeap = new PriorityQueue<>((a,b) -> a-b);
        rightHeap = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        int lSize = leftHeap.size();
        int rSize = rightHeap.size();
    
        if (lSize == rSize) {
            if (lSize == 0) {
                leftHeap.add(num);
            }else if (rightHeap.peek() <= num) {
                leftHeap.add(num);
            } else {
                leftHeap.add(rightHeap.poll());
                rightHeap.add(num);
            }
        } else {
            if (leftHeap.peek() < num) {
                rightHeap.add(leftHeap.poll());
                leftHeap.add(num);
            } else {
                rightHeap.add(num);
            }
        }
    }
    
    public double findMedian() {
        // System.out.println(leftHeap);
        int lSize = leftHeap.size();
        int rSize = rightHeap.size();
        if (lSize == rSize) {
            return (leftHeap.peek() + rightHeap.peek())/2.0;
        } else {
            return leftHeap.peek();
        }
    }
}
​
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
