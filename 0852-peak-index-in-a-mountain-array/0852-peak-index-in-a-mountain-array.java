class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length -1 ;

        int result = 0;

        while (left <= right){
            int mid = left + (right -left)/ 2;

            if (arr[mid] >= arr[mid+1]){
                result = mid;
                right = mid - 1;

            }else{
                left = mid + 1;
            }
        }
        return result;
    }
}