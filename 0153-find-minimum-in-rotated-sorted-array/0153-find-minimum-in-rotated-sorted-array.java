class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        int minValue = 0;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[n - 1]){
                left = mid + 1;
            }
            else{
                minValue = nums[mid];
                right = mid - 1;
            }
        }
        return minValue;
    }
}