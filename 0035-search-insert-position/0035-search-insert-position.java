class Solution {
    public int searchInsert(int[] nums, int target) {
        int min = 0, high = nums.length-1;
        int mid = 0;
        while(min <= high){
            mid =(min + high)/2;
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                min = mid + 1;
            }else {
                high = mid -1;
            }
        }
        return min;
    }
}