import static java.lang.Integer.MIN_VALUE;
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int maxSum = MIN_VALUE;

        for (int i = 0; i < n ; i++){
            sum = sum += nums[i];
            if(sum > maxSum){
                maxSum = sum;
            }

            if (sum < 0){
                sum = 0;
            }
        }

        return maxSum;
    }
}