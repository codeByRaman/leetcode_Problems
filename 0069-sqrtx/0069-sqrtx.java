class Solution {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;

        if (x == 0){
            return 0;
        }
        int result = -1;

        while (left <= right){
            int mid = left + (right - left) / 2;

            if (mid  == x / mid){
                return mid;
            }else if (mid > x / mid){
                right = mid - 1;
            }else {
                result = mid;
                left = mid + 1;
            }
        }
        return result;

    }
}