class Solution {
    public int maximumProduct(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int max =Integer.MIN_VALUE;
        int sec_max = Integer.MIN_VALUE;
        int third_max = Integer.MIN_VALUE;

        int min = Integer.MAX_VALUE;
        int sec_min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] > max){
                third_max = sec_max;
                sec_max = max;
                max = nums[i];
            }
            else if (nums[i] > sec_max && nums[i] <= max ){
                third_max = sec_max;
                sec_max = nums[i];
            }
            else if (nums[i] > third_max && nums[i] <= sec_max){
                third_max = nums[i];
            }
            if (nums[i] < min){
                sec_min = min;
                min = nums[i];
            }else if (nums[i] < sec_min && nums[i] >= min){
                sec_min = nums[i];
            }
        }
        int result = Math.max(max*sec_max*third_max,max*min*sec_min);
        return result;
    }
}