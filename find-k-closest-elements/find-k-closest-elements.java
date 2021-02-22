class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = Arrays.binarySearch(arr, x);
        int n = arr.length;
        if (index < 0) {
            index = Math.abs(index) - 1;
        }
        
        int left = index - 1, right = index;
        
        
        
        LinkedList<Integer> ans = new LinkedList<>();
        while(k > 0) {
            if (left < 0 && right == n) {
                break;
            }
            if (left < 0) {
                ans.addLast(arr[right++]);
            } else if (right == n) {
                ans.addFirst(arr[left--]);
            } else {
                int ldist = x - arr[left];
                int rdist = arr[right] - x;
                if (ldist <= rdist) {
                    ans.addFirst(arr[left--]);
                } else {
                    ans.addLast(arr[right++]);
                }
            }
            k--;
        }
        return ans;
    }
}