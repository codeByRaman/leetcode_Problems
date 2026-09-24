class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] fps = new int[n];
        int[] lps = new int[n];

        int mul = 1;

        for (int i = 0; i < n; i++){
            mul *= nums[i];
            fps[i] = mul;
        }

        mul = 1;

        int index = 0;
        for (int i = n-1; i >= 0; i--){
            mul *= nums[i];
            lps[index++] = mul;
        }

        for (int i = 0; i < n; i++){
            if (i == 0){
                nums[i] = lps[n-1-1];
            }
            else if (i == (n-1)){
                nums[i] = fps[i-1];
            }
            else{
                nums[i] = fps[i-1] * lps[n-2-i];
            }
        }
        return nums;
    }
}