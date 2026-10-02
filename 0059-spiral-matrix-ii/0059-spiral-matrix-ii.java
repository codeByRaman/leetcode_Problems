class Solution {
    public int[][] generateMatrix(int n) {
        int value = 1;
        int startingRow = 0;
        int startingCol = 0;
        int endingRow = n - 1;
        int endingCol = n - 1;

        int[][] result = new int[n][n];
        while (startingRow <= endingRow && startingCol <= endingCol){
            //mave to saringColumn to endingColumn then startingRow ++
            for (int col = startingCol; col <= endingCol ; col ++){
                result[startingRow][col] = value;
                value ++;
            }
            startingRow ++;

            // move to statingRow to EndingRow then endingCol --
            for(int row = startingRow ; row <= endingRow ; row ++){
                result[row][endingCol] = value;
                value ++;
            }
            endingCol --;

            // move to endingCol to startingCol then endingRow --
            if(startingRow <= endingRow){
                for (int end_col = endingCol ; end_col >= startingCol ; end_col--){
                    result[endingRow][end_col] = value;
                    value ++;
                }
                endingRow--;
            }            
            
            // move to endingRow to StartingRow then statingCol ++
            if(startingCol <= endingCol){
                for (int end_row = endingRow ; end_row >= startingRow; end_row -- ){
                    result[end_row][startingCol] = value;
                    value ++;
                }
                startingCol ++;
            }
        }
        return result;
    }
}