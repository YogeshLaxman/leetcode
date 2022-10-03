class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        Stack<int[]> stack = new Stack<>();
        
        for (int i=0; i<n; i++) {
            int[] pair = new int[] {nums[i], 1};
            while (!stack.isEmpty()) {
                if (stack.peek()[0] > nums[i]) {
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
            int[] pair = new int[] {nums[i], 1};
            while (!stack.isEmpty()) {
                if (stack.peek()[0] >= nums[i]) {
                    int[] popped = stack.pop();
                    pair[1] += popped[1];
                } else {
                    break;
                }
            }
            stack.push(pair);
            right[i] = pair[1];
        }
        
        double minSum = 0;
        for (int i=0; i<n; i++) {
            minSum += (1l * left[i] * right[i] * nums[i]);
        }
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        stack.clear();
        Arrays.fill(left, 0);
        Arrays.fill(right, 0);
        
        for (int i=0; i<n; i++) {
            int[] pair = new int[] {nums[i], 1};
            while (!stack.isEmpty()) {
                if (stack.peek()[0] < nums[i]) {
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
            int[] pair = new int[] {nums[i], 1};
            while (!stack.isEmpty()) {
                if (stack.peek()[0] <= nums[i]) {
                    int[] popped = stack.pop();
                    pair[1] += popped[1];
                } else {
                    break;
                }
            }
            stack.push(pair);
            right[i] = pair[1];
        }
        
        double maxSum = 0;
        
        for (int i=0; i<n; i++) {
            maxSum += (1l * left[i] * right[i] * nums[i]);
        }
        
        // System.out.println(maxSum + ":" + minSum);
        return (long) (maxSum - minSum);
    }
}