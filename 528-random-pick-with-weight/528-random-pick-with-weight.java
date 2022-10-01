class Solution {
    
    List<Integer> list;
    int sum;
    
    Random random = new Random();
    public Solution(int[] w) {
        list = new ArrayList<>();
        
        sum = 0;
        for (int i=0; i<w.length; i++) {
            sum += w[i];
            list.add(sum);
        }
    }
    
    public int pickIndex() {
        
        int number = random.nextInt(sum) + 1;
        
        int index = Collections.binarySearch(list, number);
        
        if (index >= 0) return index;
        
        return (-1*index) -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */