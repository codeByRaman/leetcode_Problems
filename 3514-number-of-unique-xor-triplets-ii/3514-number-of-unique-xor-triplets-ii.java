class Solution {
    public int uniqueXorTriplets(int[] nums) {
       if (nums.length == 1) return 1;

        Set<Integer> pairXor = new HashSet<>();
        Set<Integer> tripletXor = new HashSet<>();

        int n = nums.length;

        // Store all unique XORs of pairs (i <= j)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXor.add(nums[i] ^ nums[j]);
            }
        }

        // Pair XOR ^ every element
        for (int x : pairXor) {
            for (int num : nums) {
                tripletXor.add(x ^ num);
            }
        }

        return tripletXor.size();

    }
}