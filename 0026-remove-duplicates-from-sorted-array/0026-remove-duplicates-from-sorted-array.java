class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int k = 0;
        nums[k] = nums[0];
        k++;
        while (i < nums.length){
            if (nums[i] != nums[i-1]){
                nums[k] = nums[i];
                k ++;
            }
            i++;
        }
        return k;
    }
}