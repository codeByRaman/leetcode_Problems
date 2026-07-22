class Solution {
    public int countNegatives(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        
        int count_Negative = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column ; j++){
                if (grid[i][j] < 0){
                    count_Negative ++;
                }
            }
        }
        return count_Negative;
    }
}