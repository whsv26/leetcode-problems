void main() {
    assert new Solution().isValidSudoku(
        new char[][] {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'},
        }
    );
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        var seenRows = new int[9];
        var seenCols = new int[9];
        var seenSectors = new int[9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int mask = 1 << (board[i][j] - '1');
                int sector = (i / 3) * 3 + j / 3;

                if ((seenRows[i] & mask) != 0
                    || (seenCols[j] & mask) != 0
                    || (seenSectors[sector] & mask) != 0) {
                    return false;
                }

                seenRows[i] |= mask;
                seenCols[j] |= mask;
                seenSectors[sector] |= mask;
            }
        }

        return true;
    }
}