import java.util.*;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;

        // best[i] = minimum length of a valid subarray
        // completely inside arr[0...i]
        int[] best = new int[n];

        Arrays.fill(best, Integer.MAX_VALUE);

        // prefixSum -> latest index
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int prefix = 0;
        int minLength = Integer.MAX_VALUE;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            prefix += arr[i];

            // Copy previous best
            if (i > 0) {
                best[i] = best[i - 1];
            }

            // Check if a subarray with sum = target exists
            if (map.containsKey(prefix - target)) {

                int start = map.get(prefix - target);

                int currentLength = i - start;

                // Previous subarray must end before current starts
                if (start >= 0 && best[start] != Integer.MAX_VALUE) {
                    answer = Math.min(
                        answer,
                        best[start] + currentLength
                    );
                }

                // Current subarray can become the best one
                minLength = Math.min(minLength, currentLength);

                best[i] = Math.min(best[i], minLength);
            }

            map.put(prefix, i);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}