class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long ans = 0;
        int ind = nums.length - 1;

        while(k > 0){
            int value = nums[ind];

            if(mul > 1){
                ans += 1L * value *mul;
            }
            else{
                ans += value;
            }
            ind --;
            k --;
            mul --;
        }
        return ans;        
    }
}