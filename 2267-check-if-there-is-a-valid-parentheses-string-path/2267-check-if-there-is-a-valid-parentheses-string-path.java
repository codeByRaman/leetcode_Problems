class Solution {
    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Length of every possible path
        int pathLength = m + n - 1;

        // Valid parentheses string must have even length
        if (pathLength % 2 == 1) {
            return false;
        }

        // Starting with ')' is invalid
        // Ending with '(' is invalid
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        // dp[i][j][balance]
        boolean[][][] dp = new boolean[m][n][pathLength + 1];

        // Starting cell '(' -> balance = 1
        dp[0][0][1] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                int change = (grid[i][j] == '(') ? 1 : -1;

                for (int balance = 0; balance <= pathLength; balance++) {

                    int newBalance = balance + change;

                    // Balance can never be negative
                    if (newBalance < 0) {
                        continue;
                    }

                    // From top
                    if (i > 0 && dp[i - 1][j][balance]) {
                        dp[i][j][newBalance] = true;
                    }

                    // From left
                    if (j > 0 && dp[i][j - 1][balance]) {
                        dp[i][j][newBalance] = true;
                    }
                }
            }
        }

        // At the end, balance must be exactly 0
        return dp[m - 1][n - 1][0];
    }
}