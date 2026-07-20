class Solution {
    public void moveZeroes(int[] nums) {
        int n  = nums.length;

        int pos = 0;
        int move = 0;
        while (move < n){
            if(nums[move] != 0){
                nums[pos] = nums[move];
                pos ++;
            }
            move ++;
        }

        while ( pos < n){
            nums[pos] = 0;
            pos ++;
        }
    }
}