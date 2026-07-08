class Solution {
    public void swap(int[][] matrix){
        int row = matrix.length;
        int column = matrix[0].length;
        for (int j = 0 ; j < column; j++){
            int left = 0;
            int right = row -1;

            while (left < right){
                int temp = matrix[left][j];
                matrix[left][j] = matrix[right][j];
                matrix[right][j] = temp;
                left ++;
                right --;
            }
        }
    }
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        swap(matrix);

        for(int i = 0; i < row; i ++){
            for (int j = i; j < column; j++){
                if (i != j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }
}