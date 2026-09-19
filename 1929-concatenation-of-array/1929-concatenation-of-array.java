class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + n];
        int index = 0;
        for (int i =0; i < arr.length; i++){
            arr[i] = nums[index];
            index = (index + 1) % n;
        }
        return arr;
    }
}