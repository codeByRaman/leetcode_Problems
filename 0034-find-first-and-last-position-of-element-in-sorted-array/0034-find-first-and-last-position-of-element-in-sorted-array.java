class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        
        if (nums.length == 0){
            return new int[] {-1,-1};
        }
        
        // lower bound 
        int lower_bound = -1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                lower_bound = mid; 
                right = mid - 1; 
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        // upper bound 
        int upper_bound  = -1;
        left = 0;
        right = n -1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                upper_bound = mid; 
                left = mid + 1; 
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return new int[] {lower_bound,upper_bound};
    }
}