class Solution {
    public int numberOfSets(int n, int k) {
        final int MOD = 1_000_000_007;

        long[] dp = new long[k + 1];
        long[] prefix = new long[k + 1];

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                prefix[j] = (prefix[j] + dp[j - 1]) % MOD;
            }

            for (int j = 1; j <= k; j++) {
                dp[j] = (dp[j] + prefix[j]) % MOD;
            }
        }

        return (int) dp[k];
    }
}