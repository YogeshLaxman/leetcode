class Solution {
    public int firstMissingPositive(int[] A) {
        boolean onePresent = false;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                onePresent = true;
            }

            if (A[i] <= 0) {
                A[i] = 1;
            }
        }

       if (!onePresent) {
           return 1;
       }



        for (int i = 0; i < A.length; i++) {
            
            int num = Math.abs(A[i]);

            if (num <= A.length && A[num - 1] > 0) {
                A[num - 1] = -A[num - 1];
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                return i + 1;
            }
        }

        return A.length + 1;
    }
}