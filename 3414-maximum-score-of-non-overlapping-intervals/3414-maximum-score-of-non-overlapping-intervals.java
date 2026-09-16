import java.util.*;

class Solution {

    static class State {
        long score;
        int[] indices;

        State(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        int[][] a = new int[n][4];

        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0); // start
            a[i][1] = intervals.get(i).get(1); // end
            a[i][2] = intervals.get(i).get(2); // weight
            a[i][3] = i;                       // original index
        }

        // Sort by start
        Arrays.sort(a, (x, y) -> {
            if (x[0] != y[0])
                return Integer.compare(x[0], y[0]);
            return Integer.compare(x[1], y[1]);
        });

        // Find next non-overlapping interval
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {

            int low = i + 1;
            int high = n;

            while (low < high) {

                int mid = low + (high - low) / 2;

                // IMPORTANT:
                // start > current end
                if (a[mid][0] > a[i][1]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            next[i] = low;
        }

        /*
         * dp[i][k]
         * = best answer starting from i
         *   using at most k intervals
         */
        State[][] dp = new State[n + 1][5];

        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new State(0, new int[0]);
        }

        for (int i = n - 1; i >= 0; i--) {

            dp[i][0] = new State(0, new int[0]);

            for (int k = 1; k <= 4; k++) {

                // Don't take current interval
                State skip = dp[i + 1][k];

                // Take current interval
                State after = dp[next[i]][k - 1];

                int[] indices =
                        new int[after.indices.length + 1];

                indices[0] = a[i][3];

                System.arraycopy(
                        after.indices,
                        0,
                        indices,
                        1,
                        after.indices.length
                );

                Arrays.sort(indices);

                State take = new State(
                        (long) a[i][2] + after.score,
                        indices
                );

                dp[i][k] = better(skip, take);
            }
        }

        return dp[0][4].indices;
    }

    private State better(State a, State b) {

        // Higher score
        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        // Lexicographically smaller indices
        int n = Math.min(
                a.indices.length,
                b.indices.length
        );

        for (int i = 0; i < n; i++) {

            if (a.indices[i] != b.indices[i]) {
                return a.indices[i] < b.indices[i]
                        ? a
                        : b;
            }
        }

        return a.indices.length <= b.indices.length
                ? a
                : b;
    }
}