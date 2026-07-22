class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;

        for (int i = 0; i < row; i++){
            int left = 0;
            int right = column - 1;

            while (left <= right){
                int mid = left + (right -left)/2;

                if (matrix[i][mid] == target){
                    return true;
                }
                else if (matrix[i][mid] > target){
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}