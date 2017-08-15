public class Solution {
    public void solve(char[][] board) {
        if(board.length < 1) return;
        
        int row = board.length, col = board[0].length;
        
        for(int i = 0; i < row; i++) {
            checkBoarder(board, i, 0);
            if(col > 1) checkBoarder(board, i, col - 1);
        }
        
        for(int j = 0; j < col; j++) {
            checkBoarder(board, 0, j);
            if(row > 1) checkBoarder(board, row - 1, j);
        }
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == '1') board[i][j] = 'O';
            }
        }
    }
    
    public void checkBoarder(char[][] board, int i, int j) {
        int row = board.length, col = board[0].length;
        
        if(board[i][j] == 'O') {
            board[i][j] = '1';
            if(i > 1) checkBoarder(board, i - 1, j);
            if(j > 1) checkBoarder(board, i, j - 1);
            if(i < row - 1) checkBoarder(board, i + 1, j);
            if(j < col - 1) checkBoarder(board, i, j + 1);
        }
    }
}
