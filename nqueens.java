public class nqueens {
    static public boolean isSafe(int board[][], int r, int c) {
        for (int i = 0; i < c; i++) {
            if (board[r][i] == 1)
                return false;
        }
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }
        for (int i = r, j = c; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }
        return true;
    }

    static public boolean placeQueen(int board[][], int c) {
        int n = board.length;
        if (c == n)
            return true;
        for (int r = 0; r < n; r++) {
            if (isSafe(board, r, c)) {
                board[r][c] = 1;
                if (placeQueen(board, c + 1))
                    return true;
                board[r][c] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 8;
        int board[][] = new int[n][n];
        System.out.println(placeQueen(board, 0));
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.printf("%d ", board[i][j]);
            }
            System.err.printf("\n");
        }
    }
}
