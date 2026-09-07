class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                char ch = word.charAt(0);
                if(ch == board[i][j] && find(board, i, j, 0, word, visited)){
                    return true;
                }
            }
        }
        return false;
    }


    private boolean find(char[][] board, int i, int j, int idx, String word, boolean[][] visited){
        if(idx >= word.length()) return true;

        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(idx) || visited[i][j]) return false;
        visited[i][j] = true;
        boolean right = find(board, i, j+1, idx+1, word, visited);
        boolean left = find(board, i, j-1, idx+1, word, visited);
        boolean up = find(board, i-1, j, idx+1, word, visited);
        boolean down = find(board, i+1, j, idx+1, word, visited);
        visited[i][j] = false;

        return right || left || up || down;
    }
}
