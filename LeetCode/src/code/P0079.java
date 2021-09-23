package code;

public class P0079 {
    public boolean exist(char[][] board, String word) {
        boolean[][] picked = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    picked[i][j] = true;
                    if (match(board, picked, i, j, 1, word)) {
                        return true;
                    } else {
                        picked[i][j] = false;
                    }
                }
            }
        }
        return false;
    }
    private boolean match(char[][] board, boolean[][] picked, int startX, int startY, int len, String word) {
        if (len == word.length()) {
            return true;
        }
        if (startX > 0 && !picked[startX-1][startY] && board[startX-1][startY] == word.charAt(len)) {
            picked[startX-1][startY] = true;
            if (match(board, picked, startX-1, startY, len+1, word)) {
                return true;
            } else {
                picked[startX-1][startY] = false;
            }
        }
        if (startX + 1 < board.length && !picked[startX+1][startY] && board[startX+1][startY] == word.charAt(len)) {
            picked[startX+1][startY] = true;
            if (match(board, picked, startX+1, startY, len+1, word)) {
                return true;
            } else {
                picked[startX+1][startY] = false;
            }
        }
        if (startY > 0 && !picked[startX][startY-1] && board[startX][startY-1] == word.charAt(len)) {
            picked[startX][startY-1] = true;
            if (match(board, picked, startX, startY-1, len+1, word)) {
                return true;
            } else {
                picked[startX][startY-1] = false;
            }
        }
        if (startY + 1 < board[0].length && !picked[startX][startY+1] && board[startX][startY + 1] == word.charAt(len)) {
            picked[startX][startY+1] = true;
            if (match(board, picked, startX, startY + 1, len + 1, word)) {
                return true;
            } else {
                picked[startX][startY+1] = false;
            }
        }
        return false;
    }
}
