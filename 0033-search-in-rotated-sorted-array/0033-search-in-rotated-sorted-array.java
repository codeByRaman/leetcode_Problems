class Solution {
    public int pivotIndex(int[] nums){
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        int index = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[n - 1]){
                right = mid - 1;
            }
            else {
                index = mid;
                left = mid + 1;
            }
        }
         return index;
    } 
    public int search(int[] nums, int target) {
        int peekIndex = pivotIndex(nums);
        int n = nums.length;

        if (target <= nums[n-1]){
            int left = peekIndex + 1;
            int right = n - 1;

            while (left <= right){
                int mid = left + (right - left) / 2;

                if(nums[mid] == target){
                    return mid;
                }else if(nums[mid] < target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }else {
            int left = 0;
            int right = peekIndex;

            while (left <= right){
                int mid = left + (right - left) / 2;

                if(nums[mid] == target){
                    return mid;
                }else if(nums[mid] < target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}