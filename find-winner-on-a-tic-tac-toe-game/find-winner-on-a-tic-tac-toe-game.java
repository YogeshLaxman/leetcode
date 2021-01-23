class Solution {
    public String tictactoe(int[][] moves) {
        int[] row = new int[3];
        int[] col = new int[3];
        int d1 = 0, d2 = 0;
        
        for (int i=0; i<moves.length; i++) {
            int r = moves[i][0];
            int c = moves[i][1];
            
            if (i % 2 == 0) {
                row[r] += 1;
                col[c] += 1;
                if (r == c) {
                    d1++;
                }
                if (r + c == 2) {
                    d2++;
                }
                if (row[r] == 3 || col[c] == 3 || d1 == 3 || d2 == 3) {
                    return "A";
                }
            } else {
                row[r] -= 1;
                col[c] -= 1;
                if (r == c) {
                    d1--;
                }
                if (r + c == 2) {
                    d2--;
                }
                if (row[r] == -3 || col[c] == -3 || d1 == -3 || d2 == -3) {
                    return "B";
                }
            }
            
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}
