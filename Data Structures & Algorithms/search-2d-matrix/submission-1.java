class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length * matrix[0].length -1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int i = mid / matrix[0].length;
            int j = mid % matrix[0].length;
            System.out.print("i "+i+" , j "+j);
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int i = l / matrix[0].length;
        int j = l % matrix[0].length;
        if (matrix[i][j] == target) {
            return true;
        } else {
            return false;
        }
    }
}
