class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int count = 0;

        for (int i = 0; i < n; i++){
            if (nums[i] != 0){
                count ++;
            }else {
                if (count > ans){
                    ans = count;
                }
                count = 0;
            }
        }
        return Math.max(ans,count);
    }
}