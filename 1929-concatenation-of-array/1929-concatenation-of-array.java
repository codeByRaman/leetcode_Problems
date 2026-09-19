class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n + n];
        int index = 0;
        for (int i =0; i < ans.length; i++){
            ans[i] = nums[index];
            index = (index + 1) % n;
        }
        return ans;
    }
}