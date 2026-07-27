class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sec_max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            if (nums[i] >= max){
                sec_max = max;
                max = nums[i];
            }else if (nums[i] > sec_max && nums[i] < max){
                sec_max = nums[i];
            }
        }
        int result = (max-1)*(sec_max-1);
        return result;
    }
}