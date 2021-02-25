class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean do0Col = false;
        boolean do0row = false;
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        do0row = true;
                    } else {
                        matrix[i][0] = 0;
                    }
                    if (j == 0) {
                        do0Col = true;
                    } else {
                        matrix[0][j] = 0;
                    } 
                }
                
            }
        }
        
        for (int i=1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j=1; j<n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for (int j=1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i=1; i<m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (do0row) {
            for (int j=0; j<n; j++) {
                matrix[0][j] = 0;
            }
        }
        
        if (do0Col) {
            for (int i=0; i<m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}