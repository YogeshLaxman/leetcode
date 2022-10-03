class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        Stack<int[]> stack = new Stack<>();
        
        for (int i=0; i<n; i++) {
            int[] pair = new int[] {arr[i], 1};
            while (!stack.isEmpty()) {
                if (stack.peek()[0] > arr[i]) {
                    int[] popped = stack.pop();
                    pair[1] += popped[1];
                } else {
                    break;
                }
            }
            
            stack.push(pair);
            left[i] = pair[1];
        }
        
        stack.clear();
        for (int i=n-1; i>=0; i--) {
            int[] pair = new int[] {arr[i], 1};
            while (!stack.isEmpty()) {
                if (stack.peek()[0] >= arr[i]) {
                    int[] popped = stack.pop();
                    pair[1] += popped[1];
                } else {
                    break;
                }
            }
            stack.push(pair);
            right[i] = pair[1];
        }
        
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        long sum = 0;
        int modulu = 1000000007;
        for (int i=0; i<n; i++) {
            long times = (left[i] * right[i]) % modulu;
            long mult = (times * arr[i]) % modulu;
            sum = (sum + mult) % modulu;
        }
        
        return (int) (sum % modulu);
    }
}