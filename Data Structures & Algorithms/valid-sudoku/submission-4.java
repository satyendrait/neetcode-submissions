class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] counts = new int[10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    int num = Character.getNumericValue(board[i][j]);
                    counts[num] = counts[num] + 1;
                    if (counts[num] > 1)
                        return false;
                }
            }
            counts = new int[10];
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                } else {
                    int num = Character.getNumericValue(board[j][i]);
                    counts[num] = counts[num] + 1;
                    if (counts[num] > 1)
                        return false;
                }
            }
            counts = new int[10];
        }

        for (int i = 0; i < 8; i += 3) {
            for (int j = 0; j < 8; j += 3) {
                for (int l = i; l < i + 3; l++) {
                    for (int k = j; k < j + 3; k++) {
                        int num = Character.getNumericValue(board[k][l]);
                        if (board[k][l] != '.') {
                            counts[num] = counts[num] + 1;
                            if (counts[num] > 1)
                                return false;
                        }
                    }
                }
                counts = new int[10];
            }
        }
        return true;
    }
}
