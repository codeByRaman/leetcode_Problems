import static java.lang.Integer.MIN_VALUE;
class Solution {
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int n = accounts[0].length;

        int maxSum = MIN_VALUE;

        for(int i = 0; i < m; i ++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum += accounts[i][j];
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }
}