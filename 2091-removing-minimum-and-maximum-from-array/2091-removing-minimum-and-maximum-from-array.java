class Solution {
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int index_of_Min = -1;
        int index_of_Max = -1;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] > max){
                max = nums[i];
                index_of_Max = i;
            }
            if (nums[i] < min){
                min = nums[i];
                index_of_Min = i;
            }
        }
        System.out.print(index_of_Max+" -> "+max+" : "+index_of_Min+" -> "+min);

        int left = Math.max(index_of_Min, index_of_Max) + 1;

        int right = nums.length - Math.min(index_of_Min, index_of_Max);

        int both = Math.min(index_of_Min, index_of_Max) + 1
                 + nums.length - Math.max(index_of_Min, index_of_Max);

        return Math.min(left, Math.min(right, both));
    }
}