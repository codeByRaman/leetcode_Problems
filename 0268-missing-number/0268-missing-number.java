class Solution {
    public int missingNumber(int[] nums) {

        // xor basrd 
        int xorSum = 0;
        for(int num : nums)
            xorSum ^= num;
        
        for(int i = 0; i <= nums.length; i++)
            xorSum ^= i;

        return xorSum;

    }
}