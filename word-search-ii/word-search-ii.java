class Solution {
    Set<String> ansSet;
    Set<String> wordsSet;
    char[][] board;
    boolean[][] visited;
    int m, n;
    
    public List<String> findWords(char[][] board, String[] words) {
        this.ansSet = new HashSet<>();
        this.wordsSet = new HashSet<>();
        
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        
        this.visited = new boolean[m][n];
        
        for (String word: words) {
            wordsSet.add(word);
        }
        
        
        StringBuilder sb = new StringBuilder("");
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                visited[i][j] = true;
                sb.append(board[i][j]);
                dfs(i, j, sb);
                sb.deleteCharAt(sb.length()-1);
                visited[i][j] = false;
            }
        }
        
        List<String> ansList = new ArrayList<String>();
        ansList.addAll(ansSet);
        return ansList;
    }
    
    private void dfs(int i, int j, StringBuilder sb) {
        if (sb.length() > 10) {
            return;
        }
        
        String s = sb.toString();
        
        if (wordsSet.contains(s)) {
            ansSet.add(s);
        }
        
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] direction: directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            
            if (x >= 0 && y >=0 && x < m && y < n && !visited[x][y]) {
                visited[i][j] = true;
                sb.append(board[x][y]);
                dfs(x, y, sb);
                sb.deleteCharAt(sb.length()-1);
                visited[i][j] = false;
            }
        }
    }
}