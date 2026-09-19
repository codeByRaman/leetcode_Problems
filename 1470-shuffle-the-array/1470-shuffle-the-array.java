class Solution {
    public int[] shuffle(int[] nums, int n) {
        int right  = nums.length;
        int left = 0;
        int mid = left + (right - left) / 2;

        int[] ans = new int[right];

        for (int i = 0; i < ans.length; i++){
            if (i % 2 == 0){
                ans[i] = nums[left];
                left ++;
            }else{
                ans[i] = nums[mid];
                mid ++;
            }                
        }
        return ans;        
    }
}