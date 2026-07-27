class Solution {
    static boolean isValid(int[] nums,int k, int mid){
        int splitCount = 1;
        int sum = 0;

        for (int i = 0; i < nums.length; i++){
            if ((nums[i] + sum ) <= mid){
                sum += nums[i];
            }
            else {
                splitCount ++;
                if(splitCount > k || nums[i] > mid){
                    return false;
                }else {
                    sum = 0;
                    sum = sum + nums[i];
                }
            }
        }
        return true;
    }

    public int splitArray(int[] nums, int k) {
    
        int n = nums.length;

        if (n < k){
            return -1;
        }

        
        int left = 0;
        int right = 0;
        for (int num : nums){
           left = Math.max(left,num);
           right += num;
        }

        while (left < right){
            int mid = left + (right - left)/2;
            if (isValid(nums,k,mid)){
                // check whether 
                
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}